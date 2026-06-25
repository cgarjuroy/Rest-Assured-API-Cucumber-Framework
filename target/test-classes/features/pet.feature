#Author: Arjun Roy
#Feature: Pet Details

Feature: Pet detailed information
	
	
	Scenario: Display all available pet details
		Given User want to access pet details
		When Retrieve all pet details
		Then Validate details are correct

  Scenario: Add new pet details
  	Given User has new pet details
    When User add new pet details
    Then Pet is successfully added

	Scenario: Validate added pet details
		Given User has added pet ID
		When get details of added pet
		Then Pet details should be displayed
		
		
