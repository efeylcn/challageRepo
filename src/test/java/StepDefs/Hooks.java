package StepDefs;

import Utils.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setUp() throws InterruptedException {
        WebDriver driver = Driver.driverSetup("chrome");
    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final  byte[] screenshot = ((TakesScreenshot)Driver.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");

        }
        Driver.closeDriver();
    }
}
