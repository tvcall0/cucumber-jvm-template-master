#Languages and frameworks involved are Java and Selenium Webdriver within Cucumber Framework
#Instruction set for framework implementation here:
#1. http://www.seleniumframework.com/cucumber-jvm-first-project/
#Factors considered when designing this test approach are as follows:
#1. Code re-usability.
#2. An additional layer of abstraction to achieve self-documenting code
#3. Ease of use for the manual tester.
#Test data was supplied freely online via the following sources:
#1. https://the-internet.herokuapp.com/challenging_dom
#2. https://the-internet.herokuapp.com/dynamic_loading/1
#3. https://the-internet.herokuapp.com/checkboxes
#4. https://the-internet.herokuapp.com/login
#Scripts have been organized and saved off inGitHub repository:
#1. https://github.com/tvcall0/cucumber-jvm-template-master
#scripts are triggered by the user. At this stage of development, this is performed manually. However, Jenkins can be used to run large scale test suites.
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
    Then I check loading bar
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
