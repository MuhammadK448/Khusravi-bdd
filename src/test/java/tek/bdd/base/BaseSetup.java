package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

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
    public void setupBrowser(){
        /*
        *Web Driver instance
        *Navigation to retail
        *Maximize browser
        *Instantiate implicit wait
        * */
        driver = new ChromeDriver();
        //driver.get("https://retail.tekschool-students.com/");
        //driver.get("https://dev.insurance.tekschool-students.com/");
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
