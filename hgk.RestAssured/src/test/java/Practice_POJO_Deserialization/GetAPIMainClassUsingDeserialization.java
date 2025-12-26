package Practice_POJO_Deserialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAPIMainClassUsingDeserialization
{
@Test
public void deserializeTest()
{
Deserialization_MainClass dem=new Deserialization_MainClass();
dem.setId("123");
dem.setName("Apple");
//Calling Dataclass to set the value
DataClass dc=new DataClass();
dc.setColor("Black");
dc.setCapacityGB("128GB");

dem.setData(dc);
ArrayList<Deserialization_MainClass> a1=new ArrayList<Deserialization_MainClass>();
a1.add(dem);

Deserialization_MainClass dem1=new Deserialization_MainClass();
dem1.setId("231");
dem1.setName("Samsung");
//Calling Dataclass to set the value
DataClass dc1=new DataClass();
dc1.setPrice(32432.132);
dc1.setColor("Blue");

dem1.setData(dc1);

ArrayList<Deserialization_MainClass> a2=new ArrayList<Deserialization_MainClass>();
a2.add(dem1);


Deserialization_MainClass dem2=new Deserialization_MainClass();
dem2.setId("0032");
dem2.setName("OPPO");
//Calling Dataclass to set the value
DataClass dc2=new DataClass();
dc2.setCapacity("148GB");
dc2.setScreenSize("14cm");

dem2.setData(dc2);

ArrayList<Deserialization_MainClass> a3=new ArrayList<Deserialization_MainClass>();
a3.add(dem2);


ArrayList<Deserialization_MainClass> main=new ArrayList<Deserialization_MainClass>();
main.add(dem);
main.add(dem1);
main.add(dem2);

//
//System.out.println(dem.getId());
//System.out.println(dem.getName());
//System.out.println(dem.getData().getColor());


//Main code implementation start from here...


List<Deserialization_MainClass> getResponse=given().log().all().header("Content-Type","application/json")
.when().get("https://api.restful-api.dev/objects?id=4")
.then().log().all().assertThat().statusCode(200).extract().response()
.as(new TypeRef<List<Deserialization_MainClass>>() {});


//List<Deserialization_MainClass> products =
//getResponse.as(new TypeRef<List<Deserialization_MainClass>>() {});

System.out.println(getResponse.get(0).getId());
System.out.println(getResponse.get(0).getName());


}
}
