package hgk.RestAssured;

public class DeleteAddressPayload
{
public static String deletePayload(String placeID)
{
	String deleteReq="{\r\n"
			+ "    \"place_id\":\""+placeID+"\"\r\n"
			+ "}\r\n"
			+ "";
	return deleteReq;
}
}
