package LetsShopEcom_E2E_RestAssuredAPI;

import org.testng.annotations.Test;

import LetsShopEcom_E2E_RestAssuredAPI_Pages.LoginPage;
import io.restassured.specification.RequestSpecification;

public class DeleteProduct extends AddNewProduct
{
@Test(dependsOnMethods = "createNewProduct")
public void deleteAPI()
{
	//Get the utility RequestSpecification
	RequestSpecification request=LoginPage.RequestSpecwithAuth(loginTokenId).log().all();
	
	request.when().delete("/api/ecom/product/delete-product/"+productid+"")
	.then().log().all().extract().response().asString();
	
}
}
