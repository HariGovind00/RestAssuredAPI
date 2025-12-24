package CucumberStepDefinationFile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import GenericUtilityPack.EnumClass;
import hgk.LibraryAPI.LibraryAPIUtils;
import hgk.RestAssured.AddAddressPostClass;
import hgk.RestAssured.DeleteAddressPayload;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostAPIStepDef extends LibraryAPIUtils
{
	
	RequestSpecification requestGiven;
	 Response response;
	 String finalResponse;
	EnumClass getResouce;
	String enumResource;
	static String placeId;
	
	
	@Given("Add place API Trigger {string} {string} {string}")
	public void add_place_api_trigger(String name, String language, String address) throws IOException
	{
		System.out.println("Welcome Add place..");
		requestGiven=given().spec(addPlace())
				.body(AddAddressPostClass.AddpayloadStepDef(name,language,address));
	}

	@When("user call {string} method then call {string} resource")
	public Response user_call_method_then_call_resource(String methodType,String resource) 
	{
		if(methodType.equalsIgnoreCase("Post"))
		{
		getResouce=EnumClass.valueOf(resource);
	    enumResource=getResouce.getAPIResource();
	    response=requestGiven.when().post(enumResource);
		}
		else if(methodType.equalsIgnoreCase("Get"))
		{
			getResouce=EnumClass.valueOf(resource);
		    enumResource=getResouce.getAPIResource();
		    response=requestGiven.when().get(enumResource);
		}
		else if(methodType.equalsIgnoreCase("Put"))
		{
			getResouce=EnumClass.valueOf(resource);
		    enumResource=getResouce.getAPIResource();
		    response=requestGiven.when().put(enumResource);
		}
		else if(methodType.equalsIgnoreCase("Delete"))
		{
			getResouce=EnumClass.valueOf(resource);
		    enumResource=getResouce.getAPIResource();
		    response=requestGiven.when().delete(enumResource);
		}
		else
		{
			System.out.println("No HTTP method found..");
		}
		return response;
		
		}

	@Then("verify the response is Success with {string} status code")
	public void verify_the_response_is_success_with_status_code(String code) {
		
		 finalResponse=response.then().assertThat().statusCode(Integer.parseInt(code)).header("Server","Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
	}
	
	@And("Verify Response message as {string} as {string}")
	public void verify_response_message_as_as(String ActualStatus,String ExpectedStatus) 
	{
		String status=jsonPathUtil(finalResponse,ActualStatus);
		System.out.println("Actual Status:"+status);
		assertEquals(status, ExpectedStatus);
		
	}
	
	@And("Verify Get {string} API  {string} and verify the {string}")
	public void verify_get_api_and_verify_the(String TypeOfresponse,String placeid, String ExpectedName) throws IOException {
	   
		System.out.println("Welcome to Get API");
		placeId=jsonPathUtil(finalResponse,placeid);
		requestGiven=given().spec(addPlace()).queryParam("place_id",placeId);
	    response=user_call_method_then_call_resource("Get",TypeOfresponse);
	    String resp=response.asString();
	    String ActualName=jsonPathUtil(resp,"name");
	    assertEquals(ActualName, ExpectedName);
	    
	 }
	
	@Then("Verify Delete {string}")
	public void verify_delete(String deleteResource) throws IOException 
	{
       requestGiven=given().spec(addPlace()).body(DeleteAddressPayload.deletePayload(placeId));
	   response=user_call_method_then_call_resource("Delete", deleteResource);
	   String delResp=response.asString();
	   System.out.println(delResp);
	}
	
	@Given("Verify Delete place API")
	public void verify_delete_place_api() throws IOException {
		  requestGiven = given()
		            .spec(addPlace())
		            .body(DeleteAddressPayload.deletePayload(placeId));

		    response = user_call_method_then_call_resource("Delete","deletePlaceAPI");

		    System.out.println(response.asString());
	}
	
	

	

}
