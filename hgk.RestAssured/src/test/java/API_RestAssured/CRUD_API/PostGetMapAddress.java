package API_RestAssured.CRUD_API;

import org.testng.annotations.Test;

import GenericUtilityPack.EnumClass;
import hgk.LibraryAPI.LibraryAPIUtils;
import hgk.RestAssured.AddAddressPostClass;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

public class PostGetMapAddress extends LibraryAPIUtils
{
	public static String placeid;
	
@Test
public static void AddAddressAPI() throws IOException
{
	String response=given().log().all().spec(addPlace()).body(AddAddressPostClass.Addpayload())
			.when().post(EnumClass.addPlaceAPI.getAPIResource())
			.then().log().all().assertThat()
			.statusCode(200).body("scope", equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)")
			.extract().response().asString();

	JsonPath js=new JsonPath(response);
	placeid=js.getString("place_id");
	System.out.println(placeid);
}


}
