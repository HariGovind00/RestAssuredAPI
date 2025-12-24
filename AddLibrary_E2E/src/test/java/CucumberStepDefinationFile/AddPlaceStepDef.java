package CucumberStepDefinationFile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import hgk.RestAssured.AddAddressPostClass;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class AddPlaceStepDef 
{
	public static String placeid;

	@Given("^Add Place Payload (.+) (.+) (.+) with the following details$")
	public void add_place_payload_with_the_following_details(String name,String language,String address) {
	 
		System.out.println(name);
		System.out.println(language);
		System.out.println(address);
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("contentType","application/json").addQueryParam("key","qaclick123")
				.build();
		
	
	String response=given().log().all().spec(req).body(AddAddressPostClass.Addpayload())
			.when().post("/maps/api/place/add/json")
			.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)")
			.extract().response().asString();

	JsonPath js=new JsonPath(response);
	placeid=js.getString("place_id");
	System.out.println(placeid);
	}

	
}
