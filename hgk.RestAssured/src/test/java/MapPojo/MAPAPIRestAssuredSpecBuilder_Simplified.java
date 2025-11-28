package MapPojo;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MAPAPIRestAssuredSpecBuilder_Simplified {
	@Test
	public void addMap() {
		// Set the data into java object classes as part of serialization.
		// Note: In Serialization we use setMethod() to set the request body.
		// Create the object of the java object class to call setter method.
		AddMapAddressPOJO add = new AddMapAddressPOJO();
		add.setAccuracy(50);
		add.setAddress("hgk 123");
		add.setLanguage("English");
		add.setName("Tester");
		add.setPhone_number("(+91)9832454332");
		add.setWebsite("https://www.google.com");
		List<String> lst = new ArrayList<String>();
		lst.add("Shoe Park");
		lst.add("Shop");
		add.setTypes(lst);
		// Calling location class and create object to access setter method.
		LocationPojoClass loc = new LocationPojoClass();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		add.setLocation(loc);

		// Request Spec builder
		RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).addQueryParam("key", "qaclick123").build();

		// Storing the request into one RequestSpecification object to keep
		// Implimentation code clean
		RequestSpecification SimplifiedReq = given().spec(request).body(add);

		// Response Spec Builder
		ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();

//Simplified RestAssured Code given below.
		Response res = SimplifiedReq.log().all().when().post("/maps/api/place/add/json").then().spec(response).extract()
				.response();

		String str = res.asString();
		System.out.println(str);
	}
}
