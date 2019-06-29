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
			sh = wb.getSheetAt(0);}
		
		
		
		catch (FileNotFoundException e) {e.printStackTrace();}
		
		catch (IOException e) {e.printStackTrace();}
		
	}
	
	
	
	public static String getStringValue(int row, int cell) {
		excel();
		//return sh.getRow(row).getCell(cell).getStringCellValue() ;
		try {
			return sh.getRow(row).getCell(cell).getStringCellValue() ;
		} 
		catch (Exception e) {
			return "sonu";
		}
		
	}
	
	
	
	public static int getIntValue(int row, int cell) throws IOException {
		excel();
		//return sh.getRow(row).getCell(cell).getNumericCellValue();
		int data = (int) sh.getRow(row).getCell(cell).getNumericCellValue();
		return data;
	}
	
	
	public static int getRowContains(String testcasename) throws FileNotFoundException, IOException {
		
		File fl = new File(".//Data//Test_Data.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		
		int j;
		int lastrow = sh.getLastRowNum();

		String [] testcase = new String[lastrow-1];

		for(j=1;j<lastrow;j++){
		String testcases = ExcelUtils.getStringValue(j, 0);
			testcase[j-1] = testcases;
		}
		
		int i;
		int length = testcase.length;
			
		for(i=0;i<length;i++){
			if(testcase[i].equalsIgnoreCase(testcasename)) {
				break;
				}
			}
		  return i+1;	
	}

	
	

}
