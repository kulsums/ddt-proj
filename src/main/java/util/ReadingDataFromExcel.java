package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel 
{
    
	public void readExcelData() throws IOException {
		FileInputStream file = new FileInputStream("C://Users//ksiddiqu//OneDrive - Capgemini//Documents//New folder//TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("login");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		
		for (int i = 0; i < rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colcount; j++) {
				String val = row.getCell(j).toString();
				//https://www.youtube.com/watch?v=8DaPdlhDpBc&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV&index=10
				
/*				Excel -> work book -> sheets-> row -> cells

				fileIputStream  - open file in input mode - reading mode
				FileOutputStream - open file in output mode - writing mode
				XSSFWorkbook - to create object of workbook
				XSSFSheet - to interact with sheet
				XSSFRow
				XSSFCell

				above classes are provided by apache POI*/
			}
		}
	}
	
	
}
