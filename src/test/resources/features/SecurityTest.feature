Feature: Security tests scenarios

  Scenario: Validate successful sing in
    When User clicks on Sign in link
    Then Verify Sing in page is displayed
    When User enters "Khusravi987@gmail.com" and "Password@123" and licks on login
    Then User should be able to see account link

    Scenario: Sign in with Invalid username and Valid password
      When User clicks on Sign in link
      Then Verify Sing in page is displayed
      When User enters "InvalidEmail123@gmail.com" and "Password@123" and licks on login
      Then User should see error "wrong username or password"

  Scenario: Sign in with Valid username and Invalid password
    When User clicks on Sign in link
    Then Verify Sing in page is displayed
    When User enters "Khusravi987@gmail.com" and "WrongPassword@123" and licks on login
    Then User should see error "wrong username or password"