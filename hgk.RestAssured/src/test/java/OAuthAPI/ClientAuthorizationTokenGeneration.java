package OAuthAPI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import API_RestAssured.hgk.RestAssured.JSonPathClass;
import POJO_Deserialization_Json_Response.MainGetCoursesClass;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class ClientAuthorizationTokenGeneration 
{
	@BeforeMethod
	public void baseURL()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
	}
public static String oAuthTokenCreation()
{
	String OAuthToken=given().log().all()
	.formParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	.formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
	.formParam("grant_type","client_credentials")
	.formParam("scope","trust")
	.when().post("/oauthapi/oauth2/resourceOwner/token")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js=JSonPathClass.jsonPathFun(OAuthToken);
	String token=js.get("access_token");
	System.out.println(token);
	return token;
}
}
