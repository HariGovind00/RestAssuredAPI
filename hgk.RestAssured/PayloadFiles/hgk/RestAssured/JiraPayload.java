package hgk.RestAssured;

public class JiraPayload 
{
public static String createBugPayload(String Summary,String Description)
{
	String createPayload="{\r\n"
			+ "    \"fields\": {\r\n"
			+ "       \"project\":\r\n"
			+ "       {\r\n"
			+ "          \"key\": \"CCS\"\r\n"
			+ "       },\r\n"
			+ "       \"summary\": \""+Summary+"\",\r\n"
			+ "       \"description\": \""+Description+"\",\r\n"
			+ "       \"issuetype\": {\r\n"
			+ "          \"name\": \"Bug\"\r\n"
			+ "       }\r\n"
			+ "   }\r\n"
			+ "}\r\n"
			+ "";
	
	return createPayload;
}

public static String create()
{
	return "{\r\n"
			+ "    \"fields\": {\r\n"
			+ "       \"project\":\r\n"
			+ "       {\r\n"
			+ "          \"key\": \"CCS\"\r\n"
			+ "       },\r\n"
			+ "       \"summary\": \"fsddsdfhome page issue.\",\r\n"
			+ "       \"description\": \"fsdfCreating of an issue using project keys and issue type names using the REST API\",\r\n"
			+ "       \"issuetype\": {\r\n"
			+ "          \"name\": \"Bug\"\r\n"
			+ "       }\r\n"
			+ "   }\r\n"
			+ "}";
}
}
