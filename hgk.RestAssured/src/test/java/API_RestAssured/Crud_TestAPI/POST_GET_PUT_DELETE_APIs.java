package API_RestAssured.Crud_TestAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import hgk.RestAssured.AddAddressPostClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class POST_GET_PUT_DELETE_APIs
{
	@Test(invocationCount = 2)
	public void AddAddressAPI() throws InterruptedException
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("ContentType", "application/json")
		.body(AddAddressPostClass.Addpayload()).when().post("/maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)")
				.extract().response().asString();

		JsonPath js=new JsonPath(response);
		String placeid=js.getString("place_id");
		System.out.println(placeid);
		
//PUT API
		System.out.println("***************************");
		System.out.println("PUT(Update) API Triggering...");
		System.out.println("***************************");

		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().header("contentType","application/json").queryParam("key", "qaclick123")
		.body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\"70 Summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200);

		System.out.println("***************************");
		
		
		
//Get API
		System.out.println("***************************");
		System.out.println("GET API Triggering...");
		System.out.println("***************************");

		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().headers("contentType","application/json").queryParam("place_id",placeid).queryParam("key", "qaclick123")
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).body("address", equalTo("70 Summer walk, USA"));
		System.out.println("***************************");
		Thread.sleep(2000);
	
//DELETE API
		System.out.println("***************************");
		System.out.println("DELETE API Triggering...");
		System.out.println("***************************");
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().header("contentType","application/json").queryParam("key","qaclick123")
		.body("{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}\r\n"
				+ "")
		.when().delete("/maps/api/place/delete/json")
		.then().log().all().assertThat().statusCode(200);

		
		
		
	}
}
