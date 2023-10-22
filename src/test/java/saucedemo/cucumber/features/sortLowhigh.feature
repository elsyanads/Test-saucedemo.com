Feature: Sort Price low to high Products on SauceDemo
  Scenario Outline: Sort products Price low to high after login
    Given I am on loginpage
    When I login with credential username "<username>" and password "<password>"
    When I select Price low to high sorting option
    Then The first product label should "<expectedLabel>"

    Examples:
      | username        | password      | expectedLabel            |
      | standard_user   | secret_sauce  | Sauce Labs Onesie      |
      | performance_glitch_user   | secret_sauce  | Sauce Labs Onesie      |
