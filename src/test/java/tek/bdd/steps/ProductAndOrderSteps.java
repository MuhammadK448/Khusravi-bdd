package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.ShoppingCartPage;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;

public class ProductAndOrderSteps extends SeleniumUtility {

    @Then("Validate search result contains {string} for all products")
    public void validate_search_result_contains_for_all_products(String expectedSearchKeyword) {
        List<WebElement> elementList = getElementsList(HomePage.ALL_SEARCH_RESULTS_TITLE);
        //Assert.assertFalse("Search result should not be empty",elementList.isEmpty());
        for (WebElement element : elementList) {
            Assert.assertTrue(element.getText().toLowerCase()
                    .contains(expectedSearchKeyword.toLowerCase()));
        }
    }

    @When("User enters {string} on search bar and clicks on search icon")
    public void user_enters_on_search_bar_and_clicks_on_search_icon(String searchText) {
        sendText(HomePage.SEARCH_BAR_INPUT, searchText);
        clickOnElement(HomePage.SEARCH_BUTTON);
    }

    @When("User clicks on first item in search result")
    public void user_clicks_on_first_item_in_search_result() {
        clickOnElement(HomePage.FIRST_SEARCHED_PRODUCT_TITLE);
    }

    @Then("Verify there is at least {int} item in the cart")
    public void verify_there_is_at_least_item_in_the_cart(int expectedCartSize) {
        List<WebElement> cartItems = getElementsList(ShoppingCartPage.CART_ITEM_LIST);
        Assert.assertTrue(expectedCartSize > 0);
        Assert.assertEquals(cartItems.size(), expectedCartSize);
    }

    @When("User deletes all items in cart")
    public void user_deletes_all_items_in_cart() {
//        List<WebElement> elementList = getElementsList(ShoppingCartPage.CART_ITEMS_DELETE);
//        for(WebElement each : elementList){
//            clickOnElement(each);
//        }
//        //Same we can do with Lambda
//        getElementsList(ShoppingCartPage.CART_ITEMS_DELETE)
//                .forEach(each -> {
//                    clickOnElement(each);
//                });
        //Same we can do with Lambda
        getElementsList(ShoppingCartPage.CART_ITEMS_DELETE)
                .forEach(each -> clickOnElement(each));
    }

    @Then("Validate shopping cart is empty")
    public void validate_shopping_cart_is_empty() {
        boolean isDisplayed = isElementDisplayed(ShoppingCartPage.CART_EMPTY_TITLE);
        Assert.assertTrue("Cart empty title should be displayed", isDisplayed);


    }
}