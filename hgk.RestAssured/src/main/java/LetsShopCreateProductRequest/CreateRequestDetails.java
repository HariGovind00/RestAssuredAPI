package LetsShopCreateProductRequest;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class CreateRequestDetails {
	public static RequestSpecification newProductRequest(String pname, String puserid, String pcategory,
			String psubcategory, int pprice, String pdesciption, String pfor, String pimagename) {
		RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization",
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OTI5Yzk5YjUwMDhmNmE5MDk0MGE0OGEiLCJ1c2VyRW1haWwiOiJ0ZXN0cmVzdGFzc3VyZWRAZ21haWwuY29tIiwidXNlck1vYmlsZSI6ODk5ODg5ODk4OSwidXNlclJvbGUiOiJjdXN0b21lciIsImlhdCI6MTc2NDM4MDgzNCwiZXhwIjoxNzk1OTM4NDM0fQ.Cb7wXuB_MIiYwzm1O6jw5xfYOo8Sex0P2OXADhbElmA")
				.build();

		RequestSpecification simplifiedReq = given().spec(request).param("productName", pname)
				.param("productAddedBy", puserid).param("productCategory", pcategory)
				.param("productSubCategory", psubcategory).param("productPrice", pprice)
				.param("productDescription", pdesciption).param("productFor", pfor)
				.multiPart("productImage", new File("C:\\Users\\DELL\\Downloads\\" + pimagename + ".jpg"));

		return simplifiedReq;
	}
}
