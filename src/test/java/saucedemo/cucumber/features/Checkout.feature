Feature: Verify Checkout Functionality

  Scenario Outline: Verify checkout process
    Given I access the login page saucecode.com
    When Login with valid credential username "<username>" and password "<password>"
    And I choose "<product>" to the cart
    And I click the shopping cart link button
    And I click the Checkout button
    Then I should be on the checkout-step-one.html page
    And I fill in the Checkout Information with:
      | First Name | Last Name | Postal Code |
      | "<firstName>" | "<lastName>" | "<postalCode>" |
    And I click the Continue button
    Then I should be on the checkout-step-two.html page
    And I click the Finish button
    Then I should be on the checkout-complete.html page

    Examples:
      | username      | password     | product           | firstName | lastName | postalCode |
      | standard_user | secret_sauce | Sauce Labs Backpack  | Elsyana | Saltanu | 12345 |
      | problem_user | secret_sauce | Sauce Labs Bike Light | Elsyana | Saltanu | 67890 |
      | performance_glitch_user | secret_sauce | Sauce Labs Backpack  | Elsyana | Saltanu | 12345 |
      | error_user | secret_sauce | Sauce Labs Bike Light | Elsyana | Saltanu | 67890 |
      | visual_user | secret_sauce | Sauce Labs Backpack  | Elsyana | Saltanu | 12345 |
