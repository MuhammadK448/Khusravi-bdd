@Regression
Feature: Create new Account

  # Steps that are common between scenarios of specific feature
  # Background steps will execute at teh beginning of each scenario (and after the @Before hooks)
  Background: Setup create account scenarios
    When User clicks on "Sign in" link
    Then Verify Sign in page is displayed
    When User clicks on "Create New Account" link
    Then Verify Sign up page is displayed

  Scenario: Create a new account and validate it
    When User enters "Muhammad" and "random" and "1234@Password"
    When User clicks on "Sign Up" button
    Then Verify Profile page is displayed
    Then Verify new account is created
    Then validate email address in account page match

    @TestReport
    Scenario: Create account with existing email
      When User enters "Muhammad" and "flight123@gmail.com" and "1234@Password"
      When User clicks on "Sign Up" button
      Then User should see error "this email is already exist, please use another email address"
