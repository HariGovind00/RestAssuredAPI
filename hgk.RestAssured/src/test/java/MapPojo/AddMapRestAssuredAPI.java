package MapPojo;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import hgk.RestAssured.AddAddressPostClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;



public class AddMapRestAssuredAPI 
{
	@Test
	public void addMap()
	{
		//Set the data into java object classes as part of serialization.
		//Note: In Serialization we use setMethod() to set the request body.
	//Create the object of the java object class to call setter method.
		AddMapAddressPOJO add=new AddMapAddressPOJO();
		add.setAccuracy(50);
		add.setAddress("hgk 123");
		add.setLanguage("English");
		add.setName("Tester");
		add.setPhone_number("(+91)9832454332");
		add.setWebsite("https://www.google.com");
		List<String> lst=new ArrayList<String>();
		lst.add("Shoe Park");
		lst.add("Shop");
		add.setTypes(lst);
		//Calling location class and create object to access setter method.
		LocationPojoClass loc=new LocationPojoClass();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		add.setLocation(loc);
		
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response res=given().queryParam("key","quaclick123").header("content-type","application/json")
				.body(add).log().all()
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response();
		
		String str=res.asString();
		System.out.println(str);
	}
}
