Feature: Remove button in Products
  Scenario Outline: Remove a product to the cart
    Given I'm in the login-screen
    When Login with credential username "<username>" and password "<password>"
    And I add an item to the shopping cart
    And I click the Remove button
    Then the cart icon should show a decreased count

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |
      | performance_glitch_user  | secret_sauce |
      | error_user  | secret_sauce |
      | visual_user  | secret_sauce |
