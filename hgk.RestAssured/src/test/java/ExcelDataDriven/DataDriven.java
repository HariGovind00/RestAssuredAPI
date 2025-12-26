package ExcelDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	// ArrayList to store the specific row values.
	ArrayList<String> arr = new ArrayList<String>();

	public ArrayList<String> excelDataDrivenTest(String headRowName, String rowName) throws IOException {
		// Fetching the excel file to retrive the data.
		FileInputStream fis = new FileInputStream("E:\\SeleniumAutomationFreshStart\\SeleniumExcelDD.xlsx");
		// It is a class to retrive excel details.
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// To get the count of the sheet/tabs in excel.
		int sheets = workbook.getNumberOfSheets();
		System.out.println("Total count of sheet:" + sheets);

		for (int i = 0; i < sheets; i++) {
			// To get into the tab
			if (workbook.getSheetName(i).equalsIgnoreCase("LoginCred")) {
				// This is just to print the name of the tab.
				System.out.println("Name of the sheet is:" + workbook.getSheetName(i));

				// This will fetch the details present in that tab like rows & columns.
				XSSFSheet sheet = workbook.getSheetAt(i);

				// Sheet is the collection of rows and it will return rows.
				Iterator<Row> rows = sheet.iterator();

				// For now, we are only trying to fetch the cell/column of first row
				// so that we can use it as heading to iterate.
				Row firstRow = rows.next();

				// FirstRow is the collection of cells ie: header/heading.
				Iterator<Cell> cell = firstRow.cellIterator();

				// K is to fetch the index of the cellvalue
				int k = 0;
				int column = 0;
				// While loop is to fetch the heading first row column names and it's index.
				while (cell.hasNext()) {
					Cell cellValue = cell.next();
					if (cellValue.getStringCellValue().equalsIgnoreCase(headRowName)) {
						column = k;
						System.out.println("Password index is:" + column);
					}
					k++;
				}

				// Fetch the first column specific row name and it's column values.
				while (rows.hasNext()) {
					Row ColumnrowValue = rows.next();
					if (ColumnrowValue.getCell(column).getStringCellValue().equalsIgnoreCase(rowName)) {
						Iterator<Cell> columnCell = ColumnrowValue.cellIterator();
						while (columnCell.hasNext()) {
							Cell c = columnCell.next();
							arr.add(c.getStringCellValue());
						}

					}

				}

			}
		}
		return arr;
	}
}
