package LetsShopEcom_E2E_RestAssuredAPI;

import java.io.File;
import java.util.Scanner;

import org.testng.annotations.Test;

import LetsShopCreateProductRequest.AddNewProductToWebSite;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class AddNewProduct extends LoginWebSite
{
	public static String productid;
	
	@Test(dependsOnMethods = "loginUser")
	public void createNewProduct()
	{
		//String pname,String puserid,
		//String pcategory,String psubcategory,int pprice,String pdesciption,
		//String pfor,String pimagename
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter the product name:");
		String pname=sc1.nextLine();
		System.out.println("Enter the category name:");
		String pcategory=sc1.nextLine();
		System.out.println("Enter the subcategory name:");
		String psubcategory=sc1.nextLine();
		System.out.println("Enter the description name:");
		String pdescription=sc1.nextLine();
		System.out.println("Enter the pfor name:");
		String pfor=sc1.nextLine();
		System.out.println("Enter the image name:");
		String pimagename=sc1.nextLine();
		System.out.println("Enter the price:");
		int pprice=sc1.nextInt();
		
		//Main RestAPI Code to Create/Add new product to the website.
		String response=AddNewProductToWebSite.newProductRequest(loginTokenId,pname,loginUserId,pcategory,psubcategory,pprice,pdescription,pfor,pimagename).log().all().when().post("/api/ecom/product/add-product").then().log().all().extract().response().asString();
		
		//Retrive the product id from response details 
		JsonPath js=new JsonPath(response);
		productid=js.getString("productId");
		System.out.println("Product Id="+productid);
	}
}
