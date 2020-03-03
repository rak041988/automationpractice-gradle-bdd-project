Feature: User should logout succesfully

  @test
  Scenario:

    Given I navigate to automationpractise
    When  I login with user data "babutest2222@mailinator.com,12345"
    And  I should logout
    Then I verify home page
