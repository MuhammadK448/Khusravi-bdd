@Regression
Feature: Product and Order feature
  This Feature Validates everything related to product and order

  @UserStory7
 Scenario Outline: Validate search result for searched keyword
    When User enters "<SearchKeyword>" on search bar and clicks on search icon
    Then Validate search result contains "<SearchKeyword>" for all products
    Examples:
    |SearchKeyword|
    |TV           |
    |Card         |
    |Keyboard     |
    |Xbox         |
    |LED          |
    |LG           |
    |Sony         |

  @UserStory8
    Scenario: Add product in cart and delete
    Given User clicks on "Sign in" link
    Then Verify Sign in page is displayed
    When User enters "khusravi@hotmail.com" on "Email" field
    When User enters "Khusravi@123" on "Password" field
    When User clicks on "Login" button
    Then User should be able to see account link
    When User enters "TV" on search bar and clicks on search icon
    Then Validate search result contains "TV" for all products
    When User clicks on first item in search result
    When User clicks on "Add to Cart" button
    When User clicks on cart link
    Then Verify there is at least 1 item in the cart
    When User deletes all items in cart
    Then Validate shopping cart is empty

