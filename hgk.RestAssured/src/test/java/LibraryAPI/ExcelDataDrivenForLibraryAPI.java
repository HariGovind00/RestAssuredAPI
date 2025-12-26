package LibraryAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDrivenForLibraryAPI {
	// ArrayList to store the specific row values.
	ArrayList<Object> arr = new ArrayList<Object>();

	public ArrayList<Object> excelDataDrivenTest(String sheetName,String columnName,String rowName) throws IOException {
		// Fetching the excel file to retrive the data.
		FileInputStream fis = new FileInputStream("E:\\SeleniumAutomationFreshStart\\SeleniumExcelDD.xlsx");
		// It is a class to retrive excel details.
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// To get the count of the sheet/tabs in excel.
		int sheets = workbook.getNumberOfSheets();
		System.out.println("Total count of sheet:" + sheets);

		for (int i = 0; i < sheets; i++) {
			// To get into the tab
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
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
					if (cellValue.getStringCellValue().equalsIgnoreCase(columnName))
					{
						column = k;
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
							if (c.getCellType() == CellType.STRING) {
								arr.add(c.getStringCellValue());
							} else if (c.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(c)) {

								Date date = c.getDateCellValue();
								SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
								String formattedDate = sdf.format(date);
								arr.add(formattedDate);
							}
							else if (c.getCellType() == CellType.NUMERIC) {
								// Below is to convert number to text using built in fun
								arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}

						}

					}

				}

			}
		}
		return arr;
	}
}
