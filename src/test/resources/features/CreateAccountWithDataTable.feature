Feature: Create new account with data table

  Background: Setup create account scenarios
    When User clicks on "Sign in" link
    Then Verify Sign in page is displayed
    When User clicks on "Create New Account" link
    Then Verify Sign up page is displayed

    @DataTableMap
  Scenario: Using Map as Data Table
    When User enters new account information using map data
    |name|Muhammad|
    |email|random |
    |password|Pass@1234|
    When User clicks on "Sign Up" button
    Then Verify Profile page is displayed
    Then Verify new account is created
    Then validate email address in account page match

  @DataTableList
  Scenario: Using List as Data Table
    When User enters new account information as list data
      |Muhammad|
      |random |
      |Pass@1234|
    When User clicks on "Sign Up" button
    Then Verify Profile page is displayed
    Then Verify new account is created
    Then validate email address in account page match

    @SignUpErrorMessage
    Scenario: Validate error on all fields when no data entered
      When User clicks on "Sign Up" button
      Then Validate field error message
      |Name is a required field|
      |Email is a required field|
      |Password is a required field|
      |Confirm Password is a required field|