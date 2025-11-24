package API_RestAssured.CRUD_API;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetMapAddress extends PostGetMapAddress
{
	String placeid=AddAddressAPI();
@Test
public void getMapAddressDetails()
{
	System.out.println("Get API Place ID="+placeid);
	System.out.println("**************************");
	RestAssured.baseURI="https://rahulshettyacademy.com";

	given().log().all().headers("contentType","application/json").queryParam("place_id",placeid).queryParam("key", "qaclick123")
	.when().get("/maps/api/place/get/json")
	.then().log().all().assertThat().statusCode(200);
	
}
}
