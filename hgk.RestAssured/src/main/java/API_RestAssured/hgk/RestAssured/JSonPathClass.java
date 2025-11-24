package API_RestAssured.hgk.RestAssured;

import io.restassured.path.json.JsonPath;

public class JSonPathClass {
	public static JsonPath jsonPathFun(String resp) {
		JsonPath js = new JsonPath(resp);
		return js;
		

	}
}
