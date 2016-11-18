Feature: Register a user successfuly

  Scenario: Register a user

      Given I navigate to automationpractise
      When I register a user with data "@mailinator.com,Mr,uzer1,10"
      Then I verify the user registered success
    
