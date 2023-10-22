Feature: Add Products to Cart on SauceDemo
  Scenario Outline: Add a product to the cart
    Given I'm in the SauceDemo login screen
    When Login with username "<username>" and password "<password>"
    And I click the Add to Cart button
    Then the cart icon should show an increased count

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |
      | performance_glitch_user  | secret_sauce |
      | error_user  | secret_sauce |
      | visual_user  | secret_sauce |
