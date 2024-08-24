Feature: Create new Account

  Scenario: Create a new account and validate it
    When User clicks on "Sign in" link
    Then Verify Sign in page is displayed
    When User clicks on "Create New Account" link
    Then Verify Sign up page is displayed
    When User enters "Muhammad" and "random" and "1234@Password"
    When User clicks on "Sign Up" button
    Then Verify Profile page is displayed
    Then Verify new account is created
    Then validate email address in account page match