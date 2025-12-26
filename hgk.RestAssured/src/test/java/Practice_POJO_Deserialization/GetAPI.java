package Practice_POJO_Deserialization;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class GetAPI
{
@Test
public void getAPITest()
{
	String getResponse=given().log().all().header("Content-Type","application/json")
	.when().get("https://api.restful-api.dev/objects")
	.then().log().all().extract().asString();
	
	System.out.println(getResponse);
}
}
