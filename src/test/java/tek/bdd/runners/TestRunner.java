package tek.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/SecurityTest.feature",
        //features = "classpath:features", // Directory for Feature file. classpath takes care of the rest of the address before feature
        glue = "tek.bdd.steps", //Package for all the steps
        dryRun = false //set to true to scan features for unimplemented steps
)
public class TestRunner {
}
