package CucumberStepDefinationFile;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks
{
	//This class is to fetch the Place_id required to run standalone Delete API.
	//Write the code to fetch Place_id.
	
	@Before("@DeletePlaceAPI")
	public void beforeScenario() throws IOException
	{
	PostAPIStepDef post=new PostAPIStepDef();
	if(PostAPIStepDef.placeId==null)
	{
		System.out.println("Hello Hooks.");
	post.add_place_api_trigger("hgk","eng","hgk123");
	post.user_call_method_then_call_resource("Post","addPlaceAPI");
	post.verify_the_response_is_success_with_status_code("200");
	post.verify_get_api_and_verify_the("getPlaceAPI", "place_id","hgk");
	}
	else
	{
		System.out.println("Not match found.");
	}
	}

}
