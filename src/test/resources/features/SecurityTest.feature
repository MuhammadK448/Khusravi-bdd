Feature: Security tests scenarios

  Scenario: Validate successful sing in
    When User clicks on Sign in link
    Then Verify Sing in page is displayed
    When User enters correct username and password and licks on login
    Then User should be able to see account link