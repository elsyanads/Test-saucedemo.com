Feature: Sort Z to A Products on SauceDemo
  Scenario Outline: Sort products by name (A to Z) after login
    Given I'm in login page saucedemo
    When I login with username "<username>" and password "<password>"
    When I select 'Z to A' sorting option
    Then first product label should be "<expectedLabel>"

    Examples:
      | username        | password      | expectedLabel            |
      | standard_user   | secret_sauce  | Test.allTheThings() T-Shirt (Red)      |
      | performance_glitch_user   | secret_sauce  | Test.allTheThings() T-Shirt (Red)      |
