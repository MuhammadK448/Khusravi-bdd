package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.ProfilePage;
import tek.bdd.utility.SeleniumUtility;

public class ProfileSteps extends SeleniumUtility {

    @Then("Validate account name is {string}")
    public void validate_account_name_is(String expectedProfileName) {
        String actualProfileName = getElementText(ProfilePage.ACCOUNT_PROFILE_NAME_TEXT);

        Assert.assertEquals("Account Profile should Match ",
                expectedProfileName,
                actualProfileName);
    }
}
