#Author: Arjun Roy
#Feature: PetStore
#Scenario: PetStore Details

	Feature: PetStore Inventory
	
	Background: 
		Given User is in Pet Store page

  Scenario: Get PetStore Inventory Details
    When Get inventory Details
    Then Validate inventory details
    
   Scenario: Place order in PetStore
   	Given User has all details of petorder
   	When user place order
   	Then Validate schema of place order
   	
   Scenario: Get placed order details
   	Given User has placed orderId
   	When get orderId
   	Then Validate orderId status
   	
   

	

