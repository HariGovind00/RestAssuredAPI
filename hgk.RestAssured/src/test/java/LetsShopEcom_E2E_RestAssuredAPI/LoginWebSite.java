package LetsShopEcom_E2E_RestAssuredAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LetsShopEcomPojoClass.LoginDeserializationPOJO;
import LetsShopEcomPojoClass.LoginSerializationPojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class LoginWebSite
{
	
	public static RequestSpecification request()
	{
		// RequestSpecification
				RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
						.setContentType(ContentType.JSON).build();
				
				return request;
	}
	
	
	@Test(dataProvider = "loginTestData")
	public void loginUser(String username, String password) {
		
		
		// ResponseSpecification
//	ResponseSpecification response=new ResponseSpecBuilder().expectStatusCode(200)
//			.expectContentType(ContentType.JSON).build();
		
// Payload Pojo Class Serialization
		LoginSerializationPojo login = new LoginSerializationPojo();
		login.setUserEmail(username);
		login.setUserPassword(password);
		
		
		// Reqest+Body
		RequestSpecification Simplifiedreq = given().spec(request()).body(login);

		
		// Final COde
		LoginDeserializationPOJO resp = Simplifiedreq.when().post("/api/ecom/auth/login").then()
				.assertThat().statusCode(200).extract().response().as(LoginDeserializationPOJO.class);

		System.out.println("************************************");
		System.out.println("Userid=" + resp.getUserId());
		System.out.println("Token=" + resp.getToken());
		System.out.println("************************************");
	}

	@DataProvider
	public String[][] loginTestData() {
		String[][] str = new String[2][2];
		str[0][0] = "testrestassured@gmail.com";
		str[0][1] = "Welcome@123";
		str[1][0] = "testrestassured@gmail.com";
		str[1][1] = "Welcome@123";

		return str;
	}
}
