package tek.bdd.Browsers;

import org.openqa.selenium.WebDriver;

public interface BaseBrowser {
    WebDriver openBrowser(boolean isHeadless);
}
