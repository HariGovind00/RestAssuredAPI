package LetsShopEcom_E2E_RestAssuredAPI;

import org.testng.annotations.Test;

import LetsShopEcomPojoClass.MainPlaceOrderSerializationPOJO;
import LetsShopEcomPojoClass.PlaceOrderCousechild;
import LetsShopEcom_E2E_RestAssuredAPI_Pages.LoginPage;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Arrays;

public class PlaceOrder extends LoginWebSite{

	@Test
	public DeleteOrder bookOrder() {
		// Calling serialization pojo class to set value.
		PlaceOrderCousechild order = new PlaceOrderCousechild();
		order.setCountry("India");
		order.setProductOrderedId("692a30485008f6a90941065a");
		MainPlaceOrderSerializationPOJO mainorder = new MainPlaceOrderSerializationPOJO();
		mainorder.setOrders(Arrays.asList(order));

		// Request Specification
		RequestSpecification Simplifiedreq = LoginPage.RequestSpecwithAuth(loginTokenId);
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
		
		return new DeleteOrder(orderid,productid);
	}

}
