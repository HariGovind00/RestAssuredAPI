package LetsShopEcom_E2E_RestAssuredAPI_Pages;

import static io.restassured.RestAssured.given;

import LetsShopEcom_E2E_RestAssuredAPI_Payload.Payload;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LoginPage 
{
public static RequestSpecification loginReq()
{
	//RequestSpecification
		RequestSpecification request=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();
		//Reqest+Body
		RequestSpecification Simplifiedreq=given().spec(request);
		
		return Simplifiedreq;
}
public static ResponseSpecification loginResp()
{
	//ResponseSpecification
			ResponseSpecification response=new ResponseSpecBuilder().expectStatusCode(200)
					.expectContentType(ContentType.JSON).build().log().all();
			
			return response;
			
}

public static RequestSpecification RequestSpecwithAuth()
{
	//RequestSpecification
			RequestSpecification request=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					.setContentType(ContentType.JSON).addHeader("authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OTI5Yzk5YjUwMDhmNmE5MDk0MGE0OGEiLCJ1c2VyRW1haWwiOiJ0ZXN0cmVzdGFzc3VyZWRAZ21haWwuY29tIiwidXNlck1vYmlsZSI6ODk5ODg5ODk4OSwidXNlclJvbGUiOiJjdXN0b21lciIsImlhdCI6MTc2NDM4ODk4NCwiZXhwIjoxNzk1OTQ2NTg0fQ.vNokdoGCkyHlk9t2pH3Ac_H1Yf5FW44gSsbW73_EN0Y")
					.build();
			//Reqest+Body
			RequestSpecification Simplifiedreq=given().spec(request);
			
			return Simplifiedreq;
}

public static ResponseSpecification OrderPlacedResp()
{
	//ResponseSpecification
			ResponseSpecification response=new ResponseSpecBuilder().expectStatusCode(201)
					.expectContentType(ContentType.JSON).build();
			
			return response;
			
}
}
