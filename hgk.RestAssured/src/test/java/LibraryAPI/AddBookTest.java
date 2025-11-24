package LibraryAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import API_RestAssured.hgk.RestAssured.JSonPathClass;
import hgk.RestAssured.LibraryPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddBookTest
{
@Test(dataProvider = "testData")
public void addBook(String isbn1, String aisle1)
{
	System.out.println(isbn1);
	System.out.println(aisle1);
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=given().log().all().header("contentType","application/json")
	.body(LibraryPayload.payload(isbn1,aisle1)).
	when().post("/Library/Addbook.php").
	then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js=JSonPathClass.jsonPathFun(response);
	String id=js.get("ID");
	System.out.println("Added book id="+id);
}


@DataProvider
public String[][] testData()
{
	String[][] obj=new String[4][2];
	
	obj[0][0]="hari";
	obj[0][1]="2000";
	
	obj[1][0]="Amal";
	obj[1][1]="9800";
	
	obj[2][0]="Demo";
	obj[2][1]="200";
	
	obj[3][0]="Gokul";
	obj[3][1]="290";
	
	return obj;
	
}
}
