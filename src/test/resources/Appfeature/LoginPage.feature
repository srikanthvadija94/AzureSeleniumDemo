Feature: Login page feature

  Scenario: Login Page Title
    Given User is on login page
    Then User gets the title of the page
    And Page title should be "Login - My Store"

  Scenario: Forgot Password Link
    Given User is on login page
    Then Forgot your password link should be displayed

  Scenario: Login with correct credentials
    Given User is on login page
    When User enters username as "vadija.srikanth@gmail.com" in username field
    And User enters password as "srikanth@12345" in password field
    And User clicks on login button
    Then User gets the title of the page
    And Page title should be "My account - My Store"
