package API_RestAssured.CRUD_API;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetMapAddress extends PostGetMapAddress
{
@Test(dependsOnMethods = "AddAddressAPI")
public void getMapAddressDetails() throws IOException
{
	RestAssured.baseURI="https://rahulshettyacademy.com";
	given().log().all().headers("contentType","application/json")
	.queryParam("place_id",placeid).queryParam("key","qaclick123")
	.when().get("/maps/api/place/get/json")
	.then().log().all().assertThat().statusCode(200);
	
}
}
