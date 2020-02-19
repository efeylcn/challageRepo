package Pages;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    WebDriver driver;

    public LogInPage() throws InterruptedException {
        this.driver = Driver.driverSetup("chrome");
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//*[@name='form-username']")
    public WebElement userField;

    @FindBy(xpath="//*[@name='form-password']")
    public WebElement passField;

    @FindBy(id = "btnLogin")
    public WebElement logInBttn;

    @FindBy(xpath ="//*[@class='page-header jumbotron']")
    public WebElement BenefitText;

    @FindBy(id = "validation-errors")
    public WebElement IncorrectPassMsj;
//*[@id='validation-errors']

    public void login(String username, String password){

        userField.sendKeys(username);
        passField.sendKeys(password);
        logInBttn.click();
    }
}
