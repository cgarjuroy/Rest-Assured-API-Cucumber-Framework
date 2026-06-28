#Author: Arjun Roy
Feature: User Model Information
	
	@wiremock
  Scenario: Create new user
    Given User details are provided
    When New User is created
    Then Validate user is created successfully

 	@wiremock
  Scenario: New User able to login
    Given User has login credentials
    When User tries to login
    Then User will be able to login successfully

