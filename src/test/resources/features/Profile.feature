Feature: Account profile feature

  Background: Login to Account feature
    Given User clicks on "Sign in" link
    Then Verify Sign in page is displayed
    When User enters "Khusravi987@gmail.com" on "Email" field
    When User enters "Password@123" on "Password" field
    When User clicks on "Login" button
    #When User enters "Khusravi987@gmail.com" and "Password@123" and licks on login
    Then User should be able to see account link
    Given User clicks on "Account" link

    @UserStory5
    Scenario: Change name and phone number and validate
      Then Verify Profile page is displayed
      When User enters "Muhammad" on "Name" field
      When User enters "3371234567" on "Phone Number" field
      When User clicks on "Update" button
      Then Verify Toast displayed
      When wait for 5 seconds
      Then Validate account name is "Muhammad"
      When User enters "Khusravi" on "Name" field
      When User enters "5301234567" on "Phone Number" field
      When User clicks on "Update" button
      Then Verify Toast displayed
