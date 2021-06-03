@Functional
Feature: Make Posts

	Background: Post creation
		Given API is up and running
    	
   Scenario: Create new post with userId,title and body
    When Hit post creation API using endpoint "/posts" for userId <userId>
    Then API returns the response with status code as 201
    And Id is created
    And Validate the response against created userId <userId>
    
    Examples:    
    |userId|
    |1|
    |2|
    
   Scenario: Create post with existing details
   	When Hit post creation API using endpoint "/posts" for userId 1
    Then API returns the response with status code as 201
    And Id is created
    And Validate the response against created userId 1