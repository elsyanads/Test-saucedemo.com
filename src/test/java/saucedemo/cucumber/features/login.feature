@TDD
Feature: Login to SauceDemo
  Scenario Outline: Login with valid and invalid credentials
    Given I am on the login page
    When I enter "<username>" and "<password>"
    And I click the login button
    Then I should "<result>" see the products page

    Examples:
      | username         | password     | result    |
      | standard_user    | secret_sauce | success   |
      | locked_out_user  | secret_sauce | failed    |
      | problem_user    | secret_sauce | success   |
      | performance_glitch_user  | secret_sauce | success    |
      | error_user    | secret_sauce | success   |
      | visual_user  | secret_sauce | success    |

