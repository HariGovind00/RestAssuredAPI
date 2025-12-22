package LetsShopEcom_E2E_RestAssuredAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LetsShopEcomPojoClass.LoginDeserializationPOJO;
import LetsShopEcomPojoClass.LoginSerializationPojo;
import LetsShopEcom_E2E_RestAssuredAPI_Pages.LoginPage;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class LoginWebSite extends LoginPage {

	public static String loginUserId;
	public static String loginTokenId;
	
	@Test(dataProvider = "loginTestData")
	public void loginUser(String username, String password) {

// Payload Pojo Class Serialization(Converting JavaObject(value) into request payload.
		LoginSerializationPojo login = new LoginSerializationPojo();
		login.setUserEmail(username);
		login.setUserPassword(password);

//Deserialization: It mean creating pojo classes for the response received and fetching data basaed on getters.

		// Reqest+Body
		// Calling Utility class RequestSpecification method.
		RequestSpecification Simplifiedreq = given().spec(loginReq()).body(login);

		// Final Code
		LoginDeserializationPOJO resp = Simplifiedreq.when().post("/api/ecom/auth/login").then().assertThat()
				.statusCode(200).extract().response().as(LoginDeserializationPOJO.class);

		System.out.println("************************************");
		loginUserId=resp.getUserId();
		loginTokenId=resp.getToken();
		System.out.println("Userid=" + loginUserId);
		System.out.println("Token=" + loginTokenId);
		System.out.println("************************************");
	}

	@DataProvider
	public String[][] loginTestData() {
		String[][] str = new String[1][2];
		str[0][0] = "testrestassured@gmail.com";
		str[0][1] = "Welcome@123";
		

		return str;
	}
}
