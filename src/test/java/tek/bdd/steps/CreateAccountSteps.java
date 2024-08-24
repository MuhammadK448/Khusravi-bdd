package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.SignUpPage;
import tek.bdd.pages.ProfilePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.utility.RandomGenerator;
import tek.bdd.utility.SeleniumUtility;

public class CreateAccountSteps extends SeleniumUtility {

    private static String emailToUse;
    @When("User clicks on Create New Account link")
    public void user_clicks_on_create_new_account_link() {
        clickOnElement(SignInPage.Create_New_Account_Button);
    }
    @Then("Verify Sign up page is displayed")
    public void verify_sign_up_page_is_displayed() {
        String actualSignupText = getElementText(SignUpPage.SIGNUP_SUBTITLE);
        Assert.assertEquals("Sign Up", actualSignupText);
    }
    @When("User enters {string} and {string} and {string}")
    public void user_enters_and_and(String name, String email, String password) {
        // if email value is random then generate random email otherwise use the email text
        //String emailToUse = email.equalsIgnoreCase("random")//We change this to class variable inorder to access it later for newly created account email validation
        //        ? RandomGenerator.generateRandomEmail() : email;
        emailToUse = email.equalsIgnoreCase("random") ? RandomGenerator.generateRandomEmail() : email;
        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD_INPUT, password);
    }
    @Then("Verify Profile page is displayed")
    public void verify_profile_page_is_displayed() {
        String actualProfilePageTitle = getElementText(ProfilePage.PROFILE_PAGE_TITLE);
        //Message part is optional in below assertion
        Assert.assertEquals("Account Page should contain you profile text",
                "Your Profile", actualProfilePageTitle);
    }
    @Then("Verify new account is created")
    public void verify_new_account_is_created() {
        boolean profileImage = isElementDisplayed(ProfilePage.PROFILE_IMAGE);
        Assert.assertTrue(profileImage);
    }
    @Then("validate email address in account page match")
    public void validate_email_address_in_account_page_match() {
       String actualEmailText = getElementText(ProfilePage.PROFILE_EMAIL_TEXT);
       Assert.assertEquals("Actual Email should match used email for creating account",
               emailToUse, actualEmailText);
    }

}
