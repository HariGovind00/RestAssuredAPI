package LibraryAPI;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import API_RestAssured.hgk.RestAssured.JSonPathClass;
import hgk.RestAssured.LibraryPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddBookTest
{
@Test(dataProvider = "testData",invocationCount = 2)
public void addBook(String isbn1, String aisle1) throws InterruptedException
{
	
	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=given().log().all().header("contentType","application/json")
	.body(LibraryPayload.payload(isbn1,aisle1)).
	when().post("/Library/Addbook.php").
	then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js=JSonPathClass.jsonPathFun(response);
	String id=js.get("ID");
	System.out.println("Added book id="+id);
	

	
	//Get API
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String getResponse=given().log().all().header("contentType","application/json")
	.when().get("/Library/GetBook.php?ID="+id+"").
	then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	//Delete API
	
	System.out.println("Delete API...");
	RestAssured.baseURI="https://rahulshettyacademy.com";
	given().log().all().header("contentType","application/json").body("{\r\n"
			+ "    \"ID\": \""+id+"\"\r\n"
			+ "}").
	when().delete("/Library/DeleteBook.php").
	then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	

}



@DataProvider
public String[][] testData()
{
	String[][] obj=new String[4][2];
	
	obj[0][0]="hii";
	obj[0][1]="200";
	
	obj[1][0]="ll";
	obj[1][1]="900";
	
	obj[2][0]="Doo";
	obj[2][1]="200";
	
	obj[3][0]="Gol";
	obj[3][1]="200";
	
	return obj;
	
}
}
