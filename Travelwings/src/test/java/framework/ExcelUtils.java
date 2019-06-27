package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
static XSSFSheet sh;
	


	public static void excel()  {
		try {
			File fl = new File(".//Data//Test_Data.xlsx");
			FileInputStream fis = new FileInputStream(fl);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			sh = wb.getSheetAt(0);
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static String getStringValue(int row, int cell) {
		excel();
		//return sh.getRow(row).getCell(cell).getStringCellValue() ;
		try {
			return sh.getRow(row).getCell(cell).getStringCellValue() ;
		} 
		catch (Exception e) {
			return "";
		}
		
	}
	
	
	
	public static int getIntValue(int row, int cell) throws IOException {
		excel();
		//return sh.getRow(row).getCell(cell).getNumericCellValue();
		int data = (int) sh.getRow(row).getCell(cell).getNumericCellValue();
		return data;
	}
	
	
	public static void getIntValue1(int row, int cell) throws IOException {
		File fl = new File(".//Data//Test_Data.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		int data = (int) sh.getRow(row).getCell(cell).getNumericCellValue();
		System.out.println(data);

	}
	
	

}
