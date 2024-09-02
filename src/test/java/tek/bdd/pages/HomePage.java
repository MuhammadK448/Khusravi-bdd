package tek.bdd.pages;

import org.openqa.selenium.By;

public class HomePage {

    public static final By SIGN_IN_LINK = By.id("signinLink");
    public static final By ACCOUNT_LINK = By.id("accountLink");
    public static final By SEARCH_BAR_INPUT = By.id("searchInput");
    public static final By SEARCH_BUTTON = By.id("searchBtn");
    public static final By ALL_SEARCH_RESULTS_TITLE = By.xpath("//div[@class='products']//p[@class='products__name']");
    public static final By FIRST_SEARCHED_PRODUCT_TITLE = By.xpath("(//div[@class='products']//p[@class='products__name'])[1]");
    public static final By CART_LINK = By.id("cartBtn");
}
