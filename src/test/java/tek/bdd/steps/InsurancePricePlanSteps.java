package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.InsurancePricePlanPage;
import tek.bdd.pages.SignInPage;
import tek.bdd.utility.SeleniumUtility;

import java.util.*;

public class InsurancePricePlanSteps extends SeleniumUtility {
    Map<String, Map<String, String>> expectedPlanData = new HashMap<>();

    @When("User enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        sendText(InsurancePricePlanPage.USER_NAME, "supervisor");
        sendText(SignInPage.PASSWORD_INPUT, "tek_supervisor");
    }

    @Given("The Plan Price table contains the following data")
    public void the_plan_price_table_contains_the_following_data(DataTable dataTable) {
         List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
         for(Map<String, String> row : data){
             String planType = row.get("PLAN TYPE"); //Retrieves the plan type for the current row.
             Map<String, String> details = new HashMap<>(); //  Creates a new map to store details (price, created date, expire date) for the current plan type.
             // | PLAN TYPE  | PLAN BASE PRICE | DATE CREATED    | DATE EXPIRE     |
             details.put("PLAN BASE PRICE", row.get("PLAN BASE PRICE")); // Stores the plan base price in the details map.
             details.put("DATE CREATED",row.get("DATE CREATED"));
             details.put("DATE EXPIRE", row.get("DATE EXPIRE"));
            //Adds the plan type and its details to the expectedPlanData map.
             expectedPlanData.put(planType, details);
         }
    }
    @Then("Validate the table values match the expected data")
    public void Validate_the_table_values_match_the_expected_data(){
        // Find all table rows
        List<WebElement> rows = getElementsList(By.xpath("//tbody/tr"));
        //List<WebElement> rows = getDriver().findElements(By.xpath("//tbody/tr"));

        for(WebElement row : rows){
            // Find all cells in the current row
            List<WebElement>  cells = row.findElements(By.tagName("td"));
            if(cells.size() == 5){
                // we start from index 1 because index 0 is the image
                String planType = cells.get(1).getText().trim();
                String planBasePrice = cells.get(2).getText().trim();
                String dateCreated = cells.get(3).getText().trim();
                String dateExpire = cells.get(4).getText().trim();

                System.out.println("\nActual Values for Plan type : " + planType);
                System.out.println("Plan base price : " + planBasePrice);
                System.out.println("Date created : " + dateCreated);
                System.out.println("Date expires : " + dateExpire);

                //Get Expected Values
                Map<String, String> expectedValues =  expectedPlanData.get(planType);
                if(expectedValues != null){
                    //now Validate each field values
                    System.out.println("\nExpected Values ----------");
                    System.out.println(expectedValues.get("PLAN BASE PRICE"));
                    System.out.println(expectedValues.get("DATE CREATED"));
                    System.out.println(expectedValues.get("DATE EXPIRE"));
                    Assert.assertEquals("plan base price value not matching", expectedValues.get("PLAN BASE PRICE"), planBasePrice);
                    Assert.assertEquals("Created date value not matching", expectedValues.get("DATE CREATED"), dateCreated);
                    Assert.assertEquals("Expiry date value not matching", expectedValues.get("DATE EXPIRE"), dateExpire);

                    //More assert option
//                    assert planBasePrice.equals(expectedValues.get("PLAN BASE PRICE")) : "Plan Base Price for " + planType + " does not match";
//                    assert dateCreated.equals(expectedValues.get("DATE CREATED")) : "Date Created for " + planType + " does not match";
//                    assert dateExpire.equals(expectedValues.get("DATE EXPIRE")) : "Date Expire for " + planType + " does not match";
                }else {
                    throw new AssertionError("Unexpected plan type: " + planType);
                }
            }else {
                throw new AssertionError("Row does not have the expected number of cells");
            }

        }
    }
}
