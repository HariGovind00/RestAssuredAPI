package POJO_Deserialization_RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OAuthAPI.ClientAuthorizationTokenGeneration;
import POJO_Deserialization_Json_Response.MainGetCoursesClass;
import POJO_Deserialization_Json_Response.WebAutomationChild;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PojoGetCourse extends ClientAuthorizationTokenGeneration
{
	@Test
	public void getCourses() 
	
	{	
		String token=oAuthTokenCreation();
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		MainGetCoursesClass gc =given().queryParam("access_token",token)
				.when()
				.get("/oauthapi/getCourseDetails").as(MainGetCoursesClass.class);

		System.out.println("************************");
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		System.out.println(gc.getExpertise());
		List<WebAutomationChild> courses=gc.getCourses().getWebAutomation();
		ArrayList<String> arr=new ArrayList<String>();
		
		for(int i=0;i<courses.size();i++)
		{
			arr.add(courses.get(i).getCourseTitle());
			if(arr.get(i).equalsIgnoreCase("Cypress"))
			{
				System.out.println(arr.get(i)+" :"+courses.get(i).getPrice());
				break;
			}
		}
		System.out.println(arr.toString());
		String[] str= {"Cypress","Selenium Webdriver Java","Protractor"};
		List<String>expectedList=Arrays.asList(str);
		System.out.println(expectedList);
		Assert.assertTrue(arr.contains(expectedList));
		
		System.out.println("*************************");
	}
}
