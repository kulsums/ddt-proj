package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcel 
{
	public static void main(String[] args) throws IOException {
		
		readExcelData();
	}
	public static void readExcelData() throws IOException {
		FileOutputStream file = new FileOutputStream("C://Users//ksiddiqu//OneDrive - Capgemini//Documents//New folder//TestResult.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("loginResult");
		
		for (int i = 0; i < 5; i++) {
			XSSFRow row = sheet.createRow(i);
			for (int j = 0; j < 3; j++) {
				row.createCell(j).setCellValue("xyz");
			}
		}
		
		workbook.write(file);
		file.close();
	}
	
	
}
