@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @AddPlaceAPI
  Scenario Outline: Add the Address to Library API
    Given Add place API Trigger "<name>" "<language>" "<address>"
    When user call "POST" method then call "addPlaceAPI" resource
    Then verify the response is Success with "200" status code
    And Verify Response message as "status" as "OK"
    And Verify Get "getPlaceAPI" API  "place_id" and verify the "<name>"
    Examples:
    	|name				|language			|address									|
    	|RestAssured|	Eng-In			|World Crossinh Center 501|
    #	|RestAssured|	French-In		|World Crossinh Center 502|
    #	|RestAssured|	German-In		|World Crossinh Center 502|
  
    
    