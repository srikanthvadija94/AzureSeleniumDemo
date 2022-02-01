Feature: Account Page Feature

  Background: 
    Given User has already login into the Application
      | username                  | password       |
      | vadija.srikanth@gmail.com | srikanth@12345 |

  Scenario: Account Page Title
    Given User is on Accounts page
    When User gets the title of the page
    Then Page title should be "My account - My Store"

  Scenario: Accounts section count
    Given User is on Accounts page
    Then User gets accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      | Home                      |
    And Accounts section count should be 6
