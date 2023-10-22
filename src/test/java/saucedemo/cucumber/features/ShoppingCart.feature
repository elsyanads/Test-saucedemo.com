Feature: Verify Shopping Cart Functionality

  Scenario Outline: Verify products in the shopping cart
    Given I'm on login-screen
    When Login with valid username "<username>" and password "<password>"
    And I add "<product>" to the cart
    And I click the shopping cart link
    Then I should see the product "<product>" in the cart

    Examples:
      | username | password | product           |
      | standard_user | secret_sauce | Sauce Labs Backpack  |
      | problem_user | secret_sauce | Sauce Labs Onesie   |
      | performance_glitch_user | secret_sauce | Test.allTheThings() T-Shirt (Red)  |
      | error_user | secret_sauce | Sauce Labs Bolt T-Shirt  |
      | visual_user | secret_sauce | Sauce Labs Fleece Jacket  |
