package hgk.RestAssured;

public class LibraryPayload
{
public static String payload(String isbn, String aisle)
{
	String addLibraryPayload="{\r\n"
			+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
			+ "\"isbn\":\""+isbn+"\",\r\n"
			+ "\"aisle\":\""+aisle+"\",\r\n"
			+ "\"author\":\"John foer\"\r\n"
			+ "}\r\n"
			+ "";
	return addLibraryPayload;
}
}
