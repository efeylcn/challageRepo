package Pages;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    WebDriver driver;

    public DashBoardPage() {

        this.driver = Driver.driverSetup("chrome");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnAddEmployee")
    public WebElement addEmployeeBttn;


    @FindBy(xpath = "//*[@class='form-group'][1]/div[1]/input[1]")
    public WebElement firstName;

    @FindBy(xpath = "//*[@class='form-group'][2]/div[1]/input[1]")
    public WebElement lastName;

    @FindBy(xpath = "//*[@class='form-group'][3]/div[1]/input")
    public WebElement dependencyBox;


    @FindBy(xpath = "//*[@class='col-sm-offset-2 col-sm-10'][1]/button[1]")
    public WebElement submitBttn;

    @FindBy(xpath = "//*[@id='employee-table']//th[2]")
    public WebElement savedEmpLastName;

    @FindBy(xpath = "((//tbody//tr)[2]//td)[2]")
    public WebElement newLastName;

    @FindBy(xpath = "((//tbody//tr)[2]//td)[3]")
    public WebElement newName;

    @FindBy(xpath = "((//tbody//tr)[2]//td)[5]")
    public WebElement newDependent;

    @FindBy(xpath = "((//tbody//tr)[2]//td)[7]")
    public WebElement benefitCost;

    @FindBy(xpath = "((//tbody//tr)[1]//td)[9]//span[@id='btnEdit']")
    public WebElement editBttn;


    @FindBy(xpath = "((//tbody//tr)[1]//td)[3]")
    public WebElement edittedNewName;

    @FindBy(xpath = "((//tbody//tr)[1]//td)[2]")
    public WebElement edittedNewLastName;


    @FindBy(xpath = "((//tbody//tr)[1]//td)[5]")
    public WebElement edittedNewdependentNumber;

    @FindBy(xpath = "((//tbody//tr)[1]//td)[9]//span[@id='btnDelete']")
    public WebElement deleteBttn;




    public double discountCalculate(double discountRate, int dependentNumber){

        double discountAmount=  ((1000+(dependentNumber*500)-((1000+(dependentNumber*500))*0.10))/26);

        return discountAmount;
    }

    public double benefitCalculate(int dependentNumber){

        double benefitAmount = (1000+(dependentNumber*500))/26D;

        return benefitAmount;
    }

}
