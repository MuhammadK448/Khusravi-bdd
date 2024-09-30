@Regression
Feature: Insurance Portal Today's price plan

  @InsuranceTable
  Scenario: Validate Insurance price plan table data
    Then Verify "TEK Insurance App" page is displayed
    When User clicks on "Login" link
    Then Verify "Sign in to your Account" page is displayed
    When User enters "supervisor" and "tek_supervisor"
    When User clicks on "Sign In" button
    Then Verify "Customer Service Portal" page is displayed
    When User clicks on "Plans" link
    Then Verify "Plans Price" page is displayed
    Given The Plan Price table contains the following data
      | PLAN TYPE  | PLAN BASE PRICE | DATE CREATED    | DATE EXPIRE     |
      | Auto       | $175.00         | August 21, 2024 | August 22, 2024 |
      | Boat       | $424.00         | August 21, 2024 | August 22, 2024 |
      | Motorcycle | $105.00         | August 21, 2024 | August 22, 2024 |
      | Renters    | $17.00          | August 21, 2024 | August 22, 2024 |
    Then Validate the table values match the expected data