@Regression
Feature: This feature is to setup framework

  @Smoke
  Scenario: Validate top left Corner logo
    #Given Open browser and navigate to retail app  # We don't need this anymore because hooks before annotation is taking care of this
    Then Validate top left corner is TEKSCHOOL
    #Then Close the browser # we don't need this one either because hooks @After is taking care of this

  @Smoke
  Scenario: Validate top left corner logo and signin
    Then Validate top left corner is TEKSCHOOL
    And Validate Sign in button is Enabled