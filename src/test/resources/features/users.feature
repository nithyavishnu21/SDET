@Functional
Feature: List of Users

	Background: API health check up
		Given  API is up and running
		
	Scenario: Get all the users and users count
    When Hit the Get Request with the endpoint "/users"
    Then API returns the response with status code as 200
    And Users will be returned
    And Get the number of users 

  
  Scenario: User Retrieval with invalid userId
    When Hit the Get Request with the endpoint "/users/" for the userId 12
    Then API returns the response with status code as 404