package StepDefs;

import Pages.DashBoardPage;
import Pages.LogInPage;
import Utils.Config;
import Utils.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Steps {

    public static WebDriver driver;

    LogInPage logInPage = new LogInPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String dashBoardtext = "Benefits Dashboard";

    public Steps() throws InterruptedException {
        this.driver = Driver.driverSetup("chrome");
    }

    @Given("^Navigate to login page$")
    public void navigate_to_login_page() throws Throwable {

        driver.get(Config.getProperties("URL"));

    }

    @When("^User logs in with valid credentials username \"([^\"]*)\" password \"([^\"]*)\"$")
    public void user_logs_in_with_valid_credentials_username_password(String userName, String pasword) throws Throwable {

        logInPage.userField.sendKeys(userName);

        logInPage.passField.sendKeys(pasword);

        logInPage.logInBttn.click();

    }

    @Then("^Verify user is on the Dashboard$")
    public void verify_user_is_on_the_Homepage() throws Throwable {


        Assert.assertEquals(dashBoardtext, logInPage.BenefitText.getText());

    }

    @When("^User logs in with Valid username \"([^\"]*)\" INVALID password \"([^\"]*)\"$")
    public void user_logs_in_with_Valid_username_INVALID_password(String username, String pasWord) throws Throwable {

        logInPage.userField.sendKeys(username);
        logInPage.passField.sendKeys(pasWord);
        logInPage.logInBttn.click();

    }

    @Then("^Verify user gets error message$")
    public void verify_user_gets_error_message() throws Throwable {

        String msg1 = "The password is incorrect for username testUser";
        Assert.assertEquals(msg1, logInPage.IncorrectPassMsj.getText());


    }

    @When("^User logs in with INVALID username \"([^\"]*)\" VALID password \"([^\"]*)\"$")
    public void user_logs_in_with_INVALID_username_VALID_password(String username, String password) throws Throwable {


        logInPage.userField.sendKeys(username);
        logInPage.passField.sendKeys(password);
        logInPage.logInBttn.click();
    }

    @Then("^Verify user gets invalid password message$")
    public void verify_user_gets_invalid_password_message() throws Throwable {

        String msg1 = "Invalid login attempt. Please try again.";
        Assert.assertEquals(msg1, logInPage.IncorrectPassMsj.getText());


    }

    @Given("^an Employer$")
    public void an_Employer() throws Throwable {

        driver.get(Config.getProperties("URL"));
        logInPage.login(Config.getProperties("username"), Config.getProperties("password"));

    }

    @Given("^I am on the Benefits Dashboard page$")
    public void i_am_on_the_Benefits_Dashboard_page() throws Throwable {


        String expectedTitle="Benefits Dashboard";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @When("^I select Add Employee$")
    public void i_select_Add_Employee() throws Throwable {

      dashBoardPage.addEmployeeBttn.click();
    }


    @Then("^I should be able to enter employee details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iShouldBeAbleToEnterEmployeeDetails(String lastName, String name, String numOfDependent) throws Throwable {


            dashBoardPage.firstName.sendKeys(name);
            dashBoardPage.lastName.sendKeys(lastName);
            dashBoardPage.dependencyBox.sendKeys(numOfDependent);


    }

    @Then("^the employee should save$")
    public void the_employee_should_save() throws Throwable {


            dashBoardPage.submitBttn.click();

    }


    @When("^I select the Action Edit$")
    public void i_select_the_Action_Edit() throws Throwable {


        dashBoardPage.editBttn.click();

    }


    @When("^I click the Action X$")
    public void i_click_the_Action_X() throws Throwable {

        dashBoardPage.deleteBttn.click();

        // click button does NOT work !!


    }

    @And("^First Name does not begin with “A” or “a” \"([^\"]*)\"$")
    public void firstNameDoesNotBeginWithAOrA(String name) throws Throwable {

        boolean notStartWithA=!name.startsWith("A") && !name.startsWith("a");

        Assert.assertTrue(notStartWithA);
    }

    @And("^I should see the employee in the table \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iShouldSeeTheEmployeeInTheTable(String lastName, String name, String numOfDependent) throws Throwable {

       // Assert.assertTrue(dashBoardPage.newLastName.getText().equals(lastName));
       // Assert.assertTrue(dashBoardPage.newName.getText().equals(name));
        Assert.assertTrue(dashBoardPage.newDependent.getText().equals(numOfDependent));


    }


    @And("^the benefit cost calculations are correct \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void theBenefitCostCalculationsAreCorrect(String lastName, String name, String  numOfDependent) throws Throwable {


        int dependentNum=Integer.valueOf(numOfDependent);
//        Assert.assertEquals(dashBoardPage.newName.getText(),name);
//        Assert.assertEquals(dashBoardPage.newLastName.getText(),lastName);
        Assert.assertEquals(dashBoardPage.newDependent.getText(),numOfDependent);

        String benefitCost =""+dashBoardPage.benefitCalculate(dependentNum);
        String actualCost=""+Double.valueOf(dashBoardPage.benefitCost.getText());
        Assert.assertEquals(benefitCost.substring(0,5), actualCost.substring(0,5));

    }



    @And("^First Name begins with “A” or “a” \"([^\"]*)\"$")
    public void firstNameBeginsWithAOrA(String name) throws Throwable {

        boolean isStartedWithA=name.startsWith("A") || name.startsWith("a");
        Assert.assertTrue(isStartedWithA);

    }

    @And("^the employee has a (\\d+)% discount \"([^\"]*)\"$")
    public void theEmployeeHasADiscount(int discountRate, String dependentNumber) throws Throwable {

        int dependentNum=Integer.valueOf(dependentNumber);
        String discountedPrice= ""+dashBoardPage.discountCalculate(discountRate,dependentNum);

        String actualCost=""+Double.valueOf(dashBoardPage.benefitCost.getText());
        Assert.assertEquals(discountedPrice.substring(0,5), actualCost.substring(0,5));

    }

    @Then("^I can edit employee details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iCanEditEmployeeDetails(String lastName, String name, String numOfDependent) throws Throwable {

        dashBoardPage.firstName.clear();
        dashBoardPage.firstName.sendKeys(name);
        dashBoardPage.lastName.clear();
        dashBoardPage.lastName.sendKeys(lastName);
        dashBoardPage.dependencyBox.clear();
        dashBoardPage.dependencyBox.sendKeys(numOfDependent);

    }

    @And("^the data should change in the table \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void theDataShouldChangeInTheTable(String lastName, String name, String numOfDependent) throws Throwable {

        dashBoardPage.submitBttn.click();


        Assert.assertEquals(dashBoardPage.edittedNewLastName.getText(),name);
        Assert.assertEquals(dashBoardPage.edittedNewName.getText(),lastName);
        Assert.assertEquals(dashBoardPage.edittedNewdependentNumber.getText(),numOfDependent);


    }

    @Then("^the employee should be deleted \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void theEmployeeShouldBeDeleted(String lastName, String name, String numOfDependent) throws Throwable {

        /*
        * Implementation of this step should be done when the delete button works. Since, the way of how clear function works
        * is not clear.
        * */

    }



}
