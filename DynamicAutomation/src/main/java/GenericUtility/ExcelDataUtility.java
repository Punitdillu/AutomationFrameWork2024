package GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataUtility {

	/**
	 * this method is for fetchting the data from excelsheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String value
	 * @throws IOException
	 */
	
	public String getExcelsheetdata(String sheetName,int rowNum,int cellNum) throws IOException {
		
		FileInputStream fie= new FileInputStream("./src/main/resources/DATA/AutomationData.xlsx");
		Workbook wb=WorkbookFactory.create(fie);
		Sheet sh = wb.getSheet(sheetName);
		Row r=sh.getRow(rowNum);
		String data=r.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * this method is for fetchting the data from excelsheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return double value
	 * @throws IOException
	 */
	public double getExcelsheetNumericdata(String sheetName,int rowNum,int cellNum) throws IOException {
		
		FileInputStream fie= new FileInputStream("./src/main/resources/DATA/data.xlsx");
		Workbook wb=WorkbookFactory.create(fie);
		Sheet sh = wb.getSheet(sheetName);
		Row r=sh.getRow(rowNum);
		double data=r.getCell(cellNum).getNumericCellValue();
		wb.close();
		return data;
	}
	/**
	 * this method is used last row of the data page from excelsheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String value
	 * @throws IOException
	 */
	
	
public int getRowCountExcelsheetdata(String sheetName) throws IOException {
		
		FileInputStream fie= new FileInputStream(".//DATA/opportunitywithorganisation.xlsx");
		Workbook wb=WorkbookFactory.create(fie);
		Sheet sh = wb.getSheet(sheetName);
		int row=sh.getLastRowNum();
		wb.close();
		return row;
	}

/**
 * this method is used insert data in excelsheet
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return String value
 * @throws IOException
 */


public void getRowCountExcelsheetdata(String sheetName,int row,int cell,String data) throws IOException {
	
	FileInputStream fie= new FileInputStream(".//DATA/opportunitywithorganisation.xlsx");
	Workbook wb=WorkbookFactory.create(fie);
	Sheet sh = wb.getSheet(sheetName);
	Row rowNum = sh.getRow(row);
	Cell cellvalue = rowNum.createCell(cell);
	cellvalue.setCellValue(data);
	FileOutputStream fos=new FileOutputStream(".//DATA/opportunitywithorganisation.xlsx");
	wb.write(fos);
	wb.close();
	
}

}
