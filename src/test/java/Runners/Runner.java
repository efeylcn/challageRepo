package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/cucumberHTML-report", "pretty", "json:target/cucumber.json"},
        features = {"src/test/resources/Features/LogIn.feature",
                "src/test/resources/Features/AddEmployeeTest.feature",
                "src/test/resources/Features/EditDeleteEmployee.feature"},
        glue = "StepDefs",
        dryRun = false,
        tags = "@ui"

)

public class Runner {


}
