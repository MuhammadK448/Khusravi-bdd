package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tek.bdd.utility.SeleniumUtility;

public class CommonSteps extends SeleniumUtility {
    @Given("User clicks on {string} link")
    public void userClicksOnLinks(String linkText){
        clickOnElement(By.linkText(linkText));
    }
    @When("User clicks on {string} button")
    public void userClicksOnButton(String buttonText){
        String buttonXpath = "//button[text()='" + buttonText + "']";
        clickOnElement(By.xpath(buttonXpath));
    }
}
