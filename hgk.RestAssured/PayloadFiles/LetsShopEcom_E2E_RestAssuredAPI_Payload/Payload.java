package LetsShopEcom_E2E_RestAssuredAPI_Payload;

public class Payload
{
public static String loginPayload(String username,String password)
{
	String req="{\r\n"
			+ "    \"userEmail\": \""+username+"\",\r\n"
			+ "    \"userPassword\": \""+password+"\"\r\n"
			+ "}";
	return req;
}
}
