Feature: Validating Place API's

Scenario: Verify that getting a random valid user id returns the user’s details
	When user calls "UsersAPIGetUser" with path param "userId" as 1
	Then the API call got success with status code 200


Scenario: Verify that all posts have valid post ids (integer between 1-100) when getting posts for the same user
	When user calls "PostsAPI" with param "userId" as 5
	Then the API call got success with status code 200
	Then verify posts id's are valid

Scenario: Verify that doing a post using the same user with a non-empty title and body will return a correct response
	When user calls "PostsAPI" to add a post with user id 1 title "Rajitha Test" body "API Assignment"
	Then the API call got success with status code 201
	Then verify response body
	 


	

	
	
	
	
	
	

	
	
	