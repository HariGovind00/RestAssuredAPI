package LetsShopEcom_E2E_RestAssuredAPI;

import org.testng.annotations.Test;

import LetsShopEcomPojoClass.MainPlaceOrderSerializationPOJO;
import LetsShopEcomPojoClass.PlaceOrderCousechild;
import LetsShopEcom_E2E_RestAssuredAPI_Pages.LoginPage;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Arrays;

public class PlaceOrder {

	@Test
	public void bookOrder() {
		// Calling serialization pojo class to set value.
		PlaceOrderCousechild order = new PlaceOrderCousechild();
		order.setCountry("India");
		order.setProductOrderedId("68a961959320a140fe1ca57e");
		MainPlaceOrderSerializationPOJO mainorder = new MainPlaceOrderSerializationPOJO();
		mainorder.setOrders(Arrays.asList(order));

		// Request Specification
		RequestSpecification Simplifiedreq = LoginPage.RequestSpecwithAuth();
		// Response Specification
		ResponseSpecification response = LoginPage.OrderPlacedResp();

		// Actual RestAssrued Code.
		String resp = Simplifiedreq.log().all().body(mainorder).when().post("/api/ecom/order/create-order").then()
				.spec(response).log().all().extract().response().asString();

		// Response
		JsonPath js = new JsonPath(resp);
		String orderid = js.getString("orders");
		String productid = js.getString("productOrderId");
		System.out.println("Order id=" + orderid);
		System.out.println("Product id=" + productid);
	}

}
