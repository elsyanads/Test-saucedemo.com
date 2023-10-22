Feature: Login to SauceDemo with Empty Username or Password
  Scenario: Login with empty username
    Given I'm in login page
    When I enter an empty username and "<password>"
    And I click login button
    Then I should see an error message

  Scenario: Login with empty password
    Given I'm in login page
    When I enter "<username>" and an empty password
    And I click login button
    Then I should see an error message