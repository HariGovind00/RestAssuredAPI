package LetsShopEcom_E2E_RestAssuredAPI;

import org.testng.annotations.Test;

public class DeleteOrder 
{
	String orderid;
	String productid;

	public DeleteOrder(String orderid, String productid) 
	{
		super();
		this.orderid=orderid;
		this.productid=productid;
	}
	
	@Test
	public void deleteAPI()
	{
		System.out.println(orderid);
		System.out.println(productid);
	}

}
