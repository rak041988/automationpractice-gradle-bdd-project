Feature: Do user login successfully

  Scenario: As user i should able to login successfully

    Given I navigate to automationpractise
    When  I login with user data "babutest2222@mailinator.com,12345"
    Then  I verify my account page
    Then  I should logout
