package HGK_Jira_RestAssured;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import API_RestAssured.hgk.RestAssured.JSonPathClass;
import hgk.RestAssured.JiraPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;


public class CreateBugPostAPI
{
	public int bugid;
	
	@BeforeMethod
	public void baseURL()
	{
		RestAssured.baseURI="https://govindharik.atlassian.net";

	}
	
	
@Test
public int createBug()
{
	String createBugResponse=given().log().all().header("Content-Type","application/json")
	.header("Authorization","Basic Z292aW5kaGFyaWtAZ21haWwuY29tOkFUQVRUM3hGZkdGMHd2b1J1eWVaZ3NGbEtxR09Hd1l3REVmYTgxc3NDdVNZZGJZMkVNd1FfS28wa3hRemxmWmNPWDh0aW5HcnFsVFNERFg3NmZEdDNiOHpxVC1iQlY5RzY1NldrNGJrSmNyTm5OUnFJRktkNlRaSTBGX1hkb0ptMzBvV0p3Tjd2b3ZuUmlVUDdVdWV5MEgwQmtjTGVsME9MdmljREM4UFNzXzd1UmQ4LTk2ZWgzND1EQjcxMTJGQg==")
	.body(JiraPayload.createBugPayload("Testing Telefonica Website", "RestAssured Telefonica"))
	.when().post("/rest/api/2/issue")
	.then().log().all().assertThat().statusCode(201).extract().response().asString();
	
	JsonPath js=JSonPathClass.jsonPathFun(createBugResponse);
	bugid=js.getInt("id");
	System.out.println("Bug Created Id="+bugid);
	return bugid;
	
}

//public void storeId()
//{
//	int id=bugid;
//	System.out.println("Stored id="+id);
//	GetCreatedBug bug=new GetCreatedBug();
//	bug.getBugAPI(id);
//}
@Test
public void attachScreenshotToCreatedBug()
{
	
	int bugid=createBug();
	System.out.println(bugid);
	System.out.println("Welcome to attach Screenshot API...");
	given()
	.pathParam("id",bugid)
	.header("X-Atlassian-Token","no-check")
	.header("Authorization","Basic Z292aW5kaGFyaWtAZ21haWwuY29tOkFUQVRUM3hGZkdGMHd2b1J1eWVaZ3NGbEtxR09Hd1l3REVmYTgxc3NDdVNZZGJZMkVNd1FfS28wa3hRemxmWmNPWDh0aW5HcnFsVFNERFg3NmZEdDNiOHpxVC1iQlY5RzY1NldrNGJrSmNyTm5OUnFJRktkNlRaSTBGX1hkb0ptMzBvV0p3Tjd2b3ZuUmlVUDdVdWV5MEgwQmtjTGVsME9MdmljREM4UFNzXzd1UmQ4LTk2ZWgzND1EQjcxMTJGQg==")
	.multiPart("file",new File("C:\\Users\\DELL\\OneDrive\\Pictures\\Gemini_Generated_Image_yoepcmyoepcmyoep.png"))
	.when().post("/rest/api/3/issue/{id}/attachments")
	.then().assertThat().statusCode(200).extract().response().asString();
	System.out.println("Post Attach Media executed successfully...");
	//storeId();
	GetCreatedBug bug=new GetCreatedBug();
	bug.getBugAPI(bugid);
	
	
}


}
