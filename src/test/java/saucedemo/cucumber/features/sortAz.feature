Feature: Sort A to Z Products on SauceDemo
  Scenario Outline: Sort products by name (A to Z) after login
    Given I am on the saucedemo.com login page
    When I log in with username "<username>" and password "<password>"
    When I select 'A to Z' sorting option
    Then the first product label should be "<expectedLabel>"

    Examples:
      | username        | password      | expectedLabel            |
      | standard_user   | secret_sauce  | Sauce Labs Backpack      |
      | performance_glitch_user   | secret_sauce  | Sauce Labs Backpack      |
