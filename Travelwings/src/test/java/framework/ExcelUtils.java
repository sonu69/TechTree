package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static void main(String[] args) throws IOException {
		 File fl = new File(".//Data//Test_Data.xlsx");
		 FileInputStream fis = new FileInputStream(fl);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		 XSSFSheet sh = wb.getSheetAt(0);
		 String data = sh.getRow(0).getCell(0).getStringCellValue();
		 System.out.println(data);

	}

}
