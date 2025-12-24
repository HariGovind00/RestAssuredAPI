package GraphQL;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Query_MutationTest
{
@Test
public void queryTest()
{
	String queryResponse=given().header("content-type","application/json")
			.body("{\"query\":\"query\\n{\\n  location(locationId:26500)\\n  {\\n    id,\\n    name,\\n    type\\n  }\\n}\",\"variables\":null}\r\n"
					+ "")
	.when().post("https://rahulshettyacademy.com/gq/graphql")
	.then().extract().response().asString();
	
	System.out.println(queryResponse);
	JsonPath js=new JsonPath(queryResponse);
	System.out.println(js.getString("data.location.name"));
}

@Test
public void mutationest()
{
	String mutationResponse=given().header("content-type","application/json")
			.body("{\"query\":\"mutation($locname:String!, $episodename:String!)\\n{\\n  createLocation(location: {name:$locname, type: \\\"State\\\", dimension: \\\"123\\\"}) {\\n    id\\n  }\\n  editLocation(locationId: 26494, newLocationData: {name: \\\"Bihar\\\", type: \\\"State_Bih\\\", dimension: \\\"213\\\"}) {\\n    status\\n  }\\n  createEpisode(episode: {name:$episodename, air_date: \\\"23-2025\\\", episode: \\\"001\\\"}) {\\n    id\\n  }\\n  \\n  deleteEpisodes(episodeIds:[17600])\\n  {\\n    episodesDeleted\\n  }\\n}\\n\",\"variables\":{\"locname\":\"Hary\",\"episodename\":\"HarryPotter\"}}")
	.when().post("https://rahulshettyacademy.com/gq/graphql")
	.then().extract().response().asString();
	
	System.out.println(mutationResponse);

}
}
