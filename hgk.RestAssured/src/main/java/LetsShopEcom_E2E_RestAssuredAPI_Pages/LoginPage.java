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

public static RequestSpecification RequestSpecwithAuth(String loginTokenId)
{
	//RequestSpecification
			RequestSpecification request=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					.setContentType(ContentType.JSON).addHeader("authorization",loginTokenId)
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
