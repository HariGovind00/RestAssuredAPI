package API_RestAssured.CRUD_API;

import org.testng.annotations.Test;

import hgk.RestAssured.AddAddressPostClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostGetMapAddress
{
	@Test
public static String AddAddressAPI()
{
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=given().log().all().queryParam("key", "qaclick123").header("ContentType", "application/json")
	.body(AddAddressPostClass.Addpayload()).when().post("/maps/api/place/add/json")
			.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)")
			.extract().response().asString();

	JsonPath js=new JsonPath(response);
	String placeid=js.getString("place_id");
	System.out.println(placeid);
	return placeid;
}


}
