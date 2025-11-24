package API_RestAssured.CRUD_API;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteAddress
{
@Test
public void deleteExistingAddress()
{
	RestAssured.baseURI="https://rahulshettyacademy.com";
	given().log().all().header("contentType","application/json").queryParam("key","qaclick123")
	.body("{\r\n"
			+ "    \"place_id\":\"b73be8d11bab20b376364e10636beaea\"\r\n"
			+ "}\r\n"
			+ "")
	.when().delete("/maps/api/place/delete/json")
	.then().log().all().assertThat().statusCode(200);
}
}
