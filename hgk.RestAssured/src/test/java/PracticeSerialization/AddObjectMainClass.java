package PracticeSerialization;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AddObjectMainClass
{
	@Test
public void addObjectPost()
{
	AddObjectSerializationClass add=new AddObjectSerializationClass();
	add.setName("HariGovind");

	DataSubClass dat=new DataSubClass();
	dat.setYear(2025);
	dat.setPrice(50000.943);
	dat.setCpumodel("intel i10");
	dat.setHardDiskSize("2TB");
	
	add.setData(dat);
	
	
	System.out.println(add.getName());
	System.out.println(add.getData());
	
	String response=given().log().all().header("Content-Type","application/json")
	.body(add)
	.when().post("https://api.restful-api.dev/objects")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(response);
	
}
}
