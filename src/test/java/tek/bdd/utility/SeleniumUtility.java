package tek.bdd.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtility extends BaseSetup {

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }

    private WebElement waitForVisibility(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Create a method to click on a given locator
    public void clickOnElement(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    //Enter text to the located element
    public void sendText(By locator, String value) {
        waitForVisibility(locator).sendKeys(value);
    }

    //Create method for getting the text of a located element
    public String getElementText(By locator){
       return waitForVisibility(locator).getText();
    }

    public boolean isElementEnabled(By locator){
        return waitForVisibility(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator){
        return waitForVisibility(locator).isDisplayed();
    }
    //=================================Random Email Generator

    //=================================Random email Generator
}
