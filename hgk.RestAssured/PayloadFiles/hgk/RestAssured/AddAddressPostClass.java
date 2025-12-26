package hgk.RestAssured;

import java.util.ArrayList;
import java.util.HashMap;

public class AddAddressPostClass
{
public static String Addpayload()
{
	return "{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 50,\r\n"
			+ "  \"name\": \"HGK house\",\r\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
			+ "  \"types\": [\r\n"
			+ "    \"shoe park\",\r\n"
			+ "    \"shop\"\r\n"
			+ "  ],\r\n"
			+ "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \"English-IN\"\r\n"
			+ "}\r\n"
			+ "";
	
}

public static HashMap<String, Object> AddMapConvertedFromJsonToHashMap()
{
	HashMap<String,Object>map=new HashMap<String,Object>();
	map.put("accuracy",50);
	map.put("name","RestAssured");
	map.put("phone_number","(+91) 8709898787");
	map.put("address","Indra-Rekha Bhawan");
	map.put("website","https://www.hgkIR.com");
	map.put("language","Maithili");
	HashMap<String,Object>loc=new HashMap<String,Object>();
	loc.put("lat",43.43242);
	loc.put("lng", 43.534);
	map.put("location",loc);
	ArrayList<String> arr=new ArrayList<String>();
	arr.add("shoe Park");
	arr.add("shopping");
	map.put("types", arr);
	
	return map;
}

public static String AddpayloadStepDef(String name,String language,String address)
{
	return "{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"lat\": -38.383494,\r\n"
			+ "    \"lng\": 33.427362\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 50,\r\n"
			+ "  \"name\": \""+name+"\",\r\n"
			+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
			+ "  \"address\": \""+address+"\",\r\n"
			+ "  \"types\": [\r\n"
			+ "    \"shoe park\",\r\n"
			+ "    \"shop\"\r\n"
			+ "  ],\r\n"
			+ "  \"website\": \"http://google.com\",\r\n"
			+ "  \"language\": \""+language+"\"\r\n"
			+ "}\r\n"
			+ "";
	
}
}
