package OAuthAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetCoursesAPI extends ClientAuthorizationTokenGeneration
{
@Test
public void getCourses()
{
	String token=oAuthTokenCreation();
	given().log().all().queryParam("access_token",token)
	.when().get("/oauthapi/getCourseDetails")
	.then().log().all().assertThat().statusCode(401).extract().response().asString();
}
}
