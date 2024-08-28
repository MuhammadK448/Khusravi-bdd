package tek.bdd.base;

import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/*
    We can change BaseSetup class to Abstract class, when we have too many people working in our project
    to avoid changing it and to restrict object creation of it
 */
public class BaseSetup {

    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    // Encapsulating driver instance (protecting, security, Bundle data in single unit)
    private static WebDriver driver;
    private final Properties properties;

    /*
    * Find the full path of file
    * FileInputStream to read the file
    * Properties and load FileInputStream to the properties
    */

    public BaseSetup() {
        //System.getProperty("user.dir") return the locator of your project.
        try {
            String configFilePath = System.getProperty("user.dir") +
                    "/src/test/resources/configs/dev-config.properties";

            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException ex) {
            throw new RuntimeException("Something wrong with Config file", ex);
        }
    }
    //driver.get("https://retail.tekschool-students.com/");
    //driver.get("https://dev.insurance.tekschool-students.com/");
    public void setupBrowser(){
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        if(browserType.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            if(isHeadless)
                options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }else if(browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if(isHeadless)
                options.addArguments("--headless");
            driver = new EdgeDriver(options);
        }else if(browserType.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            if(isHeadless)
                options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }else {
            throw new RuntimeException("Wrong Driver is select on config file");
        }

            String url = properties.getProperty("ui.url"); // takes the value(url) of ui.url key from config.properties file
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public  void quitBrowser(){

        //null check before quit
        if(driver != null){
            driver.quit();
        }
    }

    /*
    * Giving read-only indirect access to driver.
    * restrict setting new driver instance
    * */
    public WebDriver getDriver(){
        return driver;
    }
}
