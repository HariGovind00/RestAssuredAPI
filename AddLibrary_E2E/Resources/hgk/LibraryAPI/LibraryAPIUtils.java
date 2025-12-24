package hgk.LibraryAPI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class LibraryAPIUtils
{
	public static RequestSpecification req;
	public static RequestSpecification addPlace() throws IOException
	{
		if(req==null)
		{
		//code to store the logging into a file.
		PrintStream ps=new PrintStream(new FileOutputStream("APILog.txt"));
		req=new RequestSpecBuilder().setBaseUri(envConfig())
				.addHeader("contentType","application/json").addQueryParam("key","qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(ps))
				.addFilter(ResponseLoggingFilter.logResponseTo(ps))
				.build();
		
		return req;
		}
		//If and below return is call to avoid log override so that we can see the log correctly.
		
		return req;
		
		}
	
	public static String envConfig() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\git\\repository\\RestAssured\\hgk.RestAssured\\Config.properties");
		prop.load(fis);
		return prop.getProperty("BaseURL");
		
	}
	
	public String jsonPathUtil(String response,String strSearch)
	{
		String resp=response.toString();
		JsonPath js=new JsonPath(resp);
		return js.getString(strSearch);
	}
}
