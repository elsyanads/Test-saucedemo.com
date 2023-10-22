Feature: Sort Price high to low Products on SauceDemo
  Scenario Outline: Sort products Price high to low after login
    Given I'm in login screen
    When I'm login credential username "<username>" and password "<password>"
    When I select Price high to low sorting option
    Then first product label should "<expectedLabel>"

    Examples:
      | username        | password      | expectedLabel            |
      | standard_user   | secret_sauce  | Sauce Labs Fleece Jacket      |
      | performance_glitch_user   | secret_sauce  | Sauce Labs Fleece Jacket      |
