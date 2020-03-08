package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil 
{
    
	public static String getUserName(String sheetname) throws IOException {
		FileInputStream file = new FileInputStream("C://Users//ksiddiqu//OneDrive - Capgemini//Documents//New folder//TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		String val = "";
		List<String> userSet = new ArrayList<>();
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				val = row.getCell(0).toString();
				userSet.add(val);
			}
			
			
			return val;
		}
		return val;
	}
	
	public static Object[][] getUserName_(String sheetname) throws IOException {
		FileInputStream file = new FileInputStream("C://Users//ksiddiqu//OneDrive - Capgemini//Documents//New folder//TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowcount][colcount];
		
		for (int i = 0; i < rowcount; i++) {
			for (int k = 0; k < colcount; k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
		
			}
		}
		return data;	
			
			
		}
	
	
	public static void writeTestResult(String value, String sheetname) throws IOException {
		FileOutputStream file = new FileOutputStream("C://Users//ksiddiqu//OneDrive - Capgemini//Documents//New folder//TestResult.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sheetname);
		
		for (int i = 0; i < 5; i++) {
			XSSFRow row = sheet.createRow(i);
			for (int j = 0; j < 3; j++) {
				row.createCell(j).setCellValue(value);
			}
		}
		
		workbook.write(file);
		file.close();
	}
	
	
	
}
