package ExcelDataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class DataDrivenMainClass 
{
	public static void main(String[] args) throws IOException {
	
DataDrivenForInteger dd=new DataDrivenForInteger();

ArrayList<Object> arr=dd.excelDataDrivenTest("TestCases", "AddProfile");
System.out.println(arr);
System.out.println(arr.get(1));



	}
}
