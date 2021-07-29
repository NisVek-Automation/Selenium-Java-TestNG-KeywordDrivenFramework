package nisha.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Represents the excelsheet functionality helper class.
 * @author Nisha Vekariya
 * @version 1.0
 */
public class ExcelsheetHelper {
	XSSFWorkbook workbook;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	String excelPath;

	XSSFSheet sheet;

	/**
	 * This method is constructor.
	 * @author Nisha
	 * @param excelPath-> Path of excelsheet
	 */
	public ExcelsheetHelper(String excelPath) {
		this.excelPath = excelPath;
		try {
			fis = new FileInputStream(excelPath);
			workbook = new XSSFWorkbook(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method count the rows on given sheetname.
	 * @author Nisha
	 * @param sheetName -> Sheet Name of excelsheet
	 * @return number -> return the number of rows
	 */
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			return 0;
		} else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	/**
	 * This method collects the celldata.
	 * @author Nisha
	 * @param sheetName -> Sheet Name of excelsheet
	 * @return number -> return the number of rows
	 */
	public String getCellData(String sheetName, String colName, int rowNum) {

		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		XSSFRow row = sheet.getRow(0);
		int col_Num = 0;

		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				col_Num = i;
				break;
			}
		}

		row = sheet.getRow(rowNum - 1);
		XSSFCell cell = row.getCell(col_Num);
		if (cell == null) {
			return "";
		}

		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		default:
			System.out.println("no matching enum date type found");
			break;
		}

		return colName;

	}

}
