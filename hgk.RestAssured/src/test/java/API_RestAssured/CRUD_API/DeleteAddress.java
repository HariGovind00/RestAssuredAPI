package API_RestAssured.CRUD_API;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

import GenericUtilityPack.EnumClass;
import hgk.RestAssured.DeleteAddressPayload;

public class DeleteAddress extends PostGetMapAddress
{
@Test(dependsOnMethods = "AddAddressAPI")
public void deleteExistingAddress() throws IOException
{
	given().log().all().spec(addPlace())
	.body(DeleteAddressPayload.deletePayload(placeid))
	.when().delete(EnumClass.deletePlaceAPI.getAPIResource())
	.then().log().all().assertThat().statusCode(200);
}
}
