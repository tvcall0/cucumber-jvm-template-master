Feature: Demonstration automation of single website feature 
	Use selenium java with cucumber-jvm and navigate to website

Scenario: Check Boxes 
	When I open check boxes website 
	And I verify check box 2 is checked 
	And I click check box 1 
	And I verify check box 1 is checked 
	And I click check box 2 
	Then I verify check box 2 is unchecked 
