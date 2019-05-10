package framework;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class Helper {
	
public static String captureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//String screenshotpath=System.getProperty("user.dir")+"/Screenshots/sonu"+Helper.getCurrentDateTime()+".png";
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/sonu"+".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		return screenshotpath;
	}
//	public static void takescreenshot(WebDriver driver) throws Exception {
//
//		Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
//
//		ImageIO.write(s.getImage(), "PNG", new File(System.getProperty("user.dir")+"/Screenshots/sonu"+".png"));
//	}

	public static String getCurrentDateTime() {
		DateFormat customer_format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date current_date = new Date();
		return customer_format.format(current_date);
		 
	}

	
	

	
	
	
	
	
}
