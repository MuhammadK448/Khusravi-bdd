package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.utility.SeleniumUtility;

public class SecurityTestSteps extends SeleniumUtility {

    @When("User clicks on Sign in link")
    public void user_clicks_on_sign_in_link() {
        //clickOnElement(By.id("signinLink")); without POM page
        clickOnElement(HomePage.SIGN_IN_LINK); //with POM page
    }
    @Then("Verify Sing in page is displayed")
    public void verify_sing_in_page_is_displayed() {
        //boolean signInPageSubTitle = isElementDisplayed(By.className("login__subtitle")); //No POM
        boolean signInPageSubTitle = isElementDisplayed(SignInPage.PAGE_SUBTITLE); //with POM
        //Assert.assertTrue(signInPageSubTitle);
        Assert.assertEquals("Sign in", signInPageSubTitle);
    }
    @When("User enters correct username and password and licks on login")
    public void user_enters_correct_username_and_password_and_licks_on_login() {
//        sendText(By.id("email"), "Khusravi987@gmail.com");
//        sendText(By.id("password"), "Password@123");
//        clickOnElement(By.id("loginBtn"));
        sendText(SignInPage.EMAIL_INPUT, "Khusravi987@gmail.com");
        sendText(SignInPage.PASSWORD_INPUT, "Password@123");
        clickOnElement(SignInPage.LOGIN_BUTTON);
    }
    @Then("User should be able to see account link")
    public void user_should_be_able_to_see_account_link() {
//        boolean accountLink =  isElementDisplayed(By.id("accountLink"));
        boolean accountLink =  isElementDisplayed(HomePage.ACCOUNT_LINK);
        Assert.assertTrue(accountLink);
    }
}
