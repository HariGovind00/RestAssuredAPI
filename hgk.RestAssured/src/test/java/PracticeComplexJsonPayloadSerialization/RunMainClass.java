package PracticeComplexJsonPayloadSerialization;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class RunMainClass {
//@Serialization
	@Test
	public void complexJsonSerialization() {

		ComplexMainClass com = new ComplexMainClass();
		com.setId("9988");
		com.setType("TestJson");
		com.setName("Hari");
		com.setPpu(0.21);
		
		BatterArray ba = new BatterArray();
		ba.setId("1");
		ba.setType("one");
		BatterArray ba2 = new BatterArray();
		ba2.setId("2");
		ba2.setType("two");
		BatterArray ba3 = new BatterArray();
		ba3.setId("3");
		ba3.setType("three");

		// Add Batter objects to List
		List<BatterArray> batterList = new ArrayList<>();
		batterList.add(ba);
		batterList.add(ba2);
		batterList.add(ba3);

		// Batters class object creation.
		Batters bab = new Batters();
		bab.setBatter(batterList);
		com.setBatters(bab);

		Topping top1 = new Topping();
		top1.setId("11");
		top1.setType("Eleven");
		Topping top2 = new Topping();
		top2.setId("12");
		top2.setType("Twelve");
		Topping top3 = new Topping();
		top3.setId("13");
		top3.setType("Thirteen");

		List<Topping> t = new ArrayList<Topping>();
		t.add(top1);
		t.add(top2);
		t.add(top3);
		com.setTopping(t);

//2nd set of Array List data
		ComplexMainClass com1 = new ComplexMainClass();
		com1.setId("002");
		com1.setType("Secjson");
		com1.setName("Govind");
		com1.setPpu(0.431);

		BatterArray ba1 = new BatterArray();
		ba1.setId("1");
		ba1.setType("twoone");
		BatterArray ba21 = new BatterArray();
		ba21.setId("2");
		ba21.setType("twotwo");
		BatterArray ba31 = new BatterArray();
		ba31.setId("3");
		ba31.setType("three_three");

		// Add Batter objects to List
		List<BatterArray> batterList1 = new ArrayList<>();
		batterList1.add(ba1);
		batterList1.add(ba21);
		batterList1.add(ba31);

		//Batters class object creation.
		Batters bab1 = new Batters();
		bab1.setBatter(batterList1);
		com1.setBatters(bab1);

		Topping top11 = new Topping();
		top11.setId("11");
		top11.setType("Eleven");
		Topping top21 = new Topping();
		top21.setId("12");
		top21.setType("Twelve");
		Topping top31 = new Topping();
		top31.setId("13");
		top31.setType("Thirteen");

		List<Topping> t1 = new ArrayList<Topping>();
		t1.add(top11);
		t1.add(top21);
		t1.add(top31);
		com1.setTopping(t1);

		// Adding 2 set of main class list into entry object
		List<ComplexMainClass> entry = new ArrayList<ComplexMainClass>();
		entry.add(com);
		entry.add(com1);

		// Calling the both list into one object and sending mai object as payload obj ref.
		List<ComplexMainClass> mai = new ArrayList<ComplexMainClass> ();
		mai.addAll(entry);	
		String response = given().log().all()
		.header("Content-Type","application/json")
		.body(mai)
		.when()
		.post("https://api.restful-api.dev/objects")
		.toString();
		System.out.println(response);

	}
}
