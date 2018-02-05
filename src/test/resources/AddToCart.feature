Feature: In Order to purchase it later
  As a customer
  I want add to my shopping cart

  Scenario: Customer  can add a item  to shopping cart from wish list
    Given I open "http://"automationpractice.com"
    And I login as "satti123" with "satti123"
    When I search for "The Item Startup"
    And I open the first Item
    And I add the first Item to Wish List
    And I add the first Item to shopping cart from Wish List
    And I open my shopping cart
    Then I should see the Item in my shopping cart

  Scenario: Customer  can add a item  to shopping cart from wish list
    Given I open "http://"automationpractice.com"
    And I login as "satti123" with "satti123"
    When I search for "The Item Startup"
    And I open the first Item
    And I add the first Item to Wish List
    And I add the first Item to shopping cart from Wish List
    And I open my shopping cart
    Then I should see the Item in my shopping cart