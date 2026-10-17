Feature: TestCase001
  Scenario: Add product to the cart
    Given I open shop website
    When I open first category
    And I choose first product
    And I click Add to cart button
    And I click check my cart
    Then I see added product in my cart
