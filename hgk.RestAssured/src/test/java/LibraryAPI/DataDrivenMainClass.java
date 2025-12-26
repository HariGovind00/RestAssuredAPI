package LibraryAPI;

import java.io.IOException;
import java.util.ArrayList;

public class DataDrivenMainClass 
{
	public static void main(String[] args) throws IOException {
	
ExcelDataDrivenForLibraryAPI dd=new ExcelDataDrivenForLibraryAPI();

ArrayList<Object> arr=dd.excelDataDrivenTest("Library","PayloadKey","LibraryValue");
System.out.println(arr);
System.out.println(arr.get(1));



	}
}
