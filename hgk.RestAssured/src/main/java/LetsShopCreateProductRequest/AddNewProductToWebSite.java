package LetsShopCreateProductRequest;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class AddNewProductToWebSite {
	public static RequestSpecification newProductRequest(String loginTokenId,String pname, String puserid, String pcategory,
			String psubcategory, int pprice, String pdesciption, String pfor, String pimagename) {
		
		
		RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization",loginTokenId).build();

		
		RequestSpecification simplifiedReq = given().spec(request).param("productName", pname)
				.param("productAddedBy", puserid).param("productCategory", pcategory)
				.param("productSubCategory", psubcategory).param("productPrice", pprice)
				.param("productDescription", pdesciption).param("productFor", pfor)
				.multiPart("productImage", new File("C:\\Users\\DELL\\Downloads\\" + pimagename + ".jpg"));

		return simplifiedReq;
	}
}
