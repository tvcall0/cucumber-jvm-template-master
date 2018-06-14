Feature: Demonstration automation of single website feature
  Use selenium java with cucumber-jvm and navigate to website

  Scenario: Dynamic Loading
    When I open dynamic loading website
    And I click start button
    Then I check loading bar
    Then I wait and check global greeting
