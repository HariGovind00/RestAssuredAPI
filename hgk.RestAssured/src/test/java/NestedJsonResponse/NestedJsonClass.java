package NestedJsonResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import hgk.RestAssured.NestedPayload;
import io.restassured.path.json.JsonPath;

/*
1. Print No of courses returned by API

2.Print Purchase Amount

3. Print Title of the first course

4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount

P
 */


public class NestedJsonClass
{
@Test
public void complexJsonTest()
{
	//1. Print No of courses returned by API
	JsonPath js1=new JsonPath(NestedPayload.nestedpayloadRespone());
	String courseTitle=js1.get("courses.title").toString();
	System.out.println(courseTitle);
	
	//2.Print Purchase Amount
	int purchaseAmount=js1.getInt("dashboard.purchaseAmount");
	System.out.println("Purchase Amount="+purchaseAmount);
	
	//3.Print Title of the first course
	System.out.println("First Course Title="+js1.get("courses[0].title").toString());
	
	//4.Print All course titles and their respective Prices
	//Get the size of the json array
	int sizeOfArray=js1.getInt("courses.size()");
	System.out.println(sizeOfArray);
	for(int i=0;i<sizeOfArray;i++)
	{
		System.out.println("Course Title="+js1.get("courses["+i+"].title")+" Price="+js1.get("courses["+i+"].price"));
		
	}
	//5. Print no of copies sold by RPA Course
	for(int i=0;i<sizeOfArray;i++)
	{
		if(js1.get("courses["+i+"].title").equals("RPA"))
		{
			System.out.println(i);
			System.out.println("RPA Courses Copies sold="+js1.get("courses["+i+"].copies").toString());
	
		}
		}
	//6. Verify if Sum of all Course prices matches with Purchase Amount
	int sum = 0;
	int price=0;
	for(int i=0;i<sizeOfArray;i++)
	{
		int prices=js1.getInt("courses["+i+"].price");
		int copies=js1.getInt("courses["+i+"].copies");
		
		price=prices*copies;
		sum=sum+price;
		
	}
	System.out.println("Sum of all course="+sum);
	Assert.assertEquals(sum,purchaseAmount);
}
}
