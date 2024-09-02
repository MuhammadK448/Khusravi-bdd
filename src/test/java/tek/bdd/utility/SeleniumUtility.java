package tek.bdd.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }

    private WebElement waitForVisibility(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Create a method to click on a given locator
    public void clickOnElement(By locator) {
        LOGGER.info("Clicking on Element {}", locator);
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void clickOnElement(WebElement locator) {
        LOGGER.info("Clicking on Element {}", locator);
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    //Enter text to the located element
    public void sendText(By locator, String value) {
        //LOGGER.info("Sending text {} to locator {}", value, locator);
       // waitForVisibility(locator).sendKeys(value);
        LOGGER.info("Clearing And Sending text {} to locator {}", value, locator);
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(value);
    }

    //Create method for getting the text of a located element
    public String getElementText(By locator){
        LOGGER.info("Get Element text {}", locator);
       return waitForVisibility(locator).getText();
    }

    public boolean isElementEnabled(By locator){
        LOGGER.info("Checking element is Enabled {}", locator);
        return waitForVisibility(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator){
        LOGGER.info("Checking element is Displayed {}", locator);
        return waitForVisibility(locator).isDisplayed();
    }

    public byte[] takeScreenShot(){ // Used in After hook method of HooksSteps
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

    public List<WebElement> getElementsList(By locator){
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
