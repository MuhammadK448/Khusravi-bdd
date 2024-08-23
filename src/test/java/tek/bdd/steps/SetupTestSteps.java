package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.utility.SeleniumUtility;

public class SetupTestSteps extends SeleniumUtility {

    @Given("Open browser and navigate to retail app")
    public void openBrowserAndNavigate(){

        setupBrowser();
    }

    @Then("Validate top left corner is TEKSCHOOL")
    public void validateTopLeftLogo(){
        String logoText = getElementText(By.className("top-nav__logo"));
        System.out.println(logoText);
        Assert.assertEquals("TEKSCHOOL", logoText);
    }

    @Then("Close the browser")
    public void closeBrowser(){
        quitBrowser();
    }

    @Then("Validate Sign in button is Enabled")
    public void validateSignInButtonIsEnabled(){
        //getDriver().findElement(By.id("signinLink")).isEnabled();
        boolean isSignedInBtnEnabled = isElementEnabled(By.id("signinLink")); //Using Utility Method instead
        Assert.assertTrue(isSignedInBtnEnabled);

    }
}
