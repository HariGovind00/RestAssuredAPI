package HGK_Jira_RestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetCreatedBug
{
	
@Test
public void getBugAPI(int bugid)
{
	System.out.println(bugid);
	
	String getAPIResponse=given()
	.pathParam("id",bugid)
	.log().all().header("Accept","application/json")
	.header("Authorization","Basic Z292aW5kaGFyaWtAZ21haWwuY29tOkFUQVRUM3hGZkdGMHd2b1J1eWVaZ3NGbEtxR09Hd1l3REVmYTgxc3NDdVNZZGJZMkVNd1FfS28wa3hRemxmWmNPWDh0aW5HcnFsVFNERFg3NmZEdDNiOHpxVC1iQlY5RzY1NldrNGJrSmNyTm5OUnFJRktkNlRaSTBGX1hkb0ptMzBvV0p3Tjd2b3ZuUmlVUDdVdWV5MEgwQmtjTGVsME9MdmljREM4UFNzXzd1UmQ4LTk2ZWgzND1EQjcxMTJGQg==")
	.when().get("/rest/api/3/issue/{id}")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println("********************************");
	System.out.println("Printing API Response below...");
	System.out.println(getAPIResponse);
}
}
