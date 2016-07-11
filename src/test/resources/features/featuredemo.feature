Feature: Demonstration automation of multiple website features
  Use selenium java with cucumber-jvm and navigate to website

  Scenario: Challenging DOM
    When I open challenging dom website
    And I validate table data
    And I verify the number in the answer box
    And I check blue button text
    And I click blue button
    And I check blue button text
    Then I verify the updated number in the answer box

  Scenario: Dynamic Loading
    When I open dynamic loading website
    And I click start button
    And I check loading bar
    Then I wait and check global greeting

  Scenario: Check Boxes
    When I open check boxes website
    And I verify check box 2 is checked
    And I click check box 1
    And I verify check box 1 is checked
    And I click check box 2
    Then I verify check box 2 is unchecked

  Scenario: Auth
    When I open auth website
    And I enter invalid username
    And I enter invalid password
    And I click login button
    Then I verify error message is displayed
