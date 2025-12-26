package LibraryAPI;

import org.testng.annotations.Test;

import API_RestAssured.hgk.RestAssured.JSonPathClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AddBookTest
{
@Test
public void addBook() throws InterruptedException, IOException
{
	ExcelDataDrivenForLibraryAPI dd=new ExcelDataDrivenForLibraryAPI();
	ArrayList<Object> arr=dd.excelDataDrivenTest("Library","PayloadKey","LibraryValue");
	System.out.println(arr);
	
	
	HashMap<String,Object> map=new HashMap<String,Object>();
	map.put("name",arr.get(1));
	map.put("isbn",arr.get(2));
	map.put("aisle",arr.get(3));
	map.put("author",arr.get(4));
	
	
	
	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=given().log().all().header("Content-Type","application/json")
	.body(map).
	when().post("/Library/Addbook.php").
	then().log().all().extract().response().asString();
	
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



//@DataProvider
//public String[][] testData()
//{
//	String[][] obj=new String[4][2];
//	
//	obj[0][0]="hii";
//	obj[0][1]="200";
//	
//	obj[1][0]="ll";
//	obj[1][1]="900";
//	
//	obj[2][0]="Doo";
//	obj[2][1]="200";
//	
//	obj[3][0]="Gol";
//	obj[3][1]="200";
//	
//	return obj;
//	
//}
}
