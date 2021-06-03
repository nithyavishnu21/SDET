@Functional
Feature: Comment on Posts

	Background: Commenting on the post
		Given API is up and running
    	
   Scenario Outline: Create comment with postId,name,email and body
   	When Hit comment API using endpoint "/comments" on postId <postId>
    Then API returns the response with status code as 201
    And Id is created
    And Validate the response against created postId <postId>
    
    Examples:  
    |postId|
    |1|
    |2|
    
    Scenario: Create post with existing details
   	When Hit comment API using endpoint "/comments" on postId 1
    Then API returns the response with status code as 201
    And Id is created
    And Validate the response against created postId 1
