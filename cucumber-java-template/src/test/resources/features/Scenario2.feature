Feature: Demonstration automation of single website feature
  Use selenium java with cucumber-jvm and navigate to website

  Scenario: Challenging DOM
    When I open challenging dom website
    And I validate table data
    And I verify the number in the answer box
    And I check blue button text
    And I click blue button
    And I check blue button text
    Then I verify the updated number in the answer box
