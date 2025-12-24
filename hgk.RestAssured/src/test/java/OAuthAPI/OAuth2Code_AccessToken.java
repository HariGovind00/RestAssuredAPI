package OAuthAPI;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class OAuth2Code_AccessToken
{
	/*
	 * scope:https://www.googleapis.com/auth/userinfo.email
auth_url:https://accounts.google.com/o/oauth2/v2/auth
client_id:692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com
response_type:code
redirect_uri:https://rahulshettyacademy.com/getCourse.php
	 */
@Test
public void OAuth2Code_AccessToken()
{
	
	String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0ATX87lN1aG-mJojCr1afEe3Wjlpmsuu4EQvXvX52NxYTVDLZFtoBKsxwziIQg4QldOs7WA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
	String fetchCode=url.split("code=")[1].split("&scope=")[0].trim();
	System.out.println(fetchCode);
	/*
	 * code:4%2F0ATX87lOGafgm1kEKWmTuVlRtVozckiys5oZwgLwGDcELdyXG3eEx780CrkprGvt9vvWf2w
client_id:692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com
client_secret:erZOWM9g3UtwNRj340YYaK_W
redirect_uri:https://rahulshettyacademy.com/getCourse.php
grant_type:authorization_code
	 */
	
	String AccessTokenResponse=given().urlEncodingEnabled(false).log().all()
			.queryParam("code",fetchCode)
			.queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
			.queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
			.queryParam("grant_type","authorization_code")
			.when()
			.post("https://www.googleapis.com/oauth2/v4/token")
			.asString();
			System.out.println(AccessTokenResponse);
			
			JsonPath js=new JsonPath(AccessTokenResponse);
			String accessToken=js.getString("access_token");
			System.out.println(accessToken);
			
//			
	//Actual API
			
			String coureseResponse=given()
			.queryParam("access_token",accessToken)
			.when().get("https://rahulshettyacademy.com/getCourse.php")
			.then().log().all().extract()
			.asString();
			
			System.out.println(coureseResponse);
}
}
