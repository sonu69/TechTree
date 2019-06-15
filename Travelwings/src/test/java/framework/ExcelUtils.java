package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
static XSSFSheet sh;
	


	public static void excel() throws IOException {
		File fl = new File("/home/ttuser/git/Techtree/Travelwings/Data/Test_Data.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		
		
	}
	
	
	
	public static String getStringValue(int row, int cell) throws IOException {
		excel();
		return sh.getRow(row).getCell(cell).getStringCellValue();
	}
	
	
	
	public static double getIntValue(int row, int cell) throws IOException {
		excel();
		return sh.getRow(row).getCell(cell).getNumericCellValue();
	}
	
	

}
