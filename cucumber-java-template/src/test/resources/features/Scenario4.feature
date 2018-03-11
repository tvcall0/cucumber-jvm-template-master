Feature: Demonstration automation of single website feature
  Use selenium java with cucumber-jvm and navigate to website

  Scenario: Auth
    When I open auth website
    And I enter invalid username
    And I enter invalid password
    And I click login button
    Then I verify error message is displayed
