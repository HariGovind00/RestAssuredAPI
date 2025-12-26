package JsonToHasMapDemo;

import java.util.ArrayList;
import java.util.HashMap;

public class GoogleAddMapPayload
{
	public static HashMap<String,Object> jsonToHasMapGoogleMapAddAPIPayload()
	{
		
		{
			/* 
			 
			  "location": {
			    "lat": -38.383494,
			    "lng": 33.427362
			  },
			  "accuracy": 50,
			  "name": "Frontline house",
			  "phone_number": "(+91) 983 893 3937",
			  "address": "29, side layout, cohen 09",
			  "types": [
			    "shoe park",
			    "shop"  ],
			  "website": "http://google.com",
			  "language": "French-IN"
			} 
			*/
	HashMap<String,Object>map=new HashMap<String,Object>();
	map.put("accuracy",50);
	map.put("name","Hari");
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

	}
}
