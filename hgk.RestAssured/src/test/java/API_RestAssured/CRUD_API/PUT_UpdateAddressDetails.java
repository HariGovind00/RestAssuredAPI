package API_RestAssured.CRUD_API;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PUT_UpdateAddressDetails
{
@Test
public void updateDetailsTest()
{
	RestAssured.baseURI="https://rahulshettyacademy.com";
	given().log().all().header("contentType","application/json").queryParam("key", "qaclick123")
	.body("{\r\n"
			+ "\"place_id\":\"77e718136c12de67e9b8b69715bf4478\",\r\n"
			+ "\"address\":\"70 Summer walk, USA\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}\r\n"
			+ "")
	.when().put("/maps/api/place/update/json")
	.then().log().all().assertThat().statusCode(200);
}
}
