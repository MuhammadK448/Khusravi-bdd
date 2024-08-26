package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    //Insurance page
    @Then("Verify {string} page is displayed")
    public void verify_page_title_is_displayed(String titleText) {
        String pageTitleXpath = "//h2[contains(text(),'" + titleText + "')]";
        isElementDisplayed(By.xpath(pageTitleXpath));
    }
}
