package framework;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


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

	public static String takescreenshot(WebDriver driver) throws Exception {

		//String screenshotpath=System.getProperty("user.dir")+"/Screenshots/sonu"+Helper.getCurrentDateTime()+".png";
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/sonu"+".png";
		
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	    
		try {
			ImageIO.write(fpScreenshot.getImage(),"PNG",new File(screenshotpath));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	     return screenshotpath;
	}

	
	public static String fullpagescreenshot(WebDriver driver) throws IOException, InterruptedException {
		
		
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/sonu"+".png";
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/Screenshots/sonu1"+".png"));
		WebElement elements = driver.findElement(By.xpath("//div[@class='amount']/span[@class='ng-binding']"));    
		Thread.sleep(3000L);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int yPosition = elements.getLocation().getY();
		js.executeScript("window.scroll (0, " + yPosition + ") ");      
		Thread.sleep(3000L);         
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File(System.getProperty("user.dir")+"/Screenshots/sonu2"+".png"));
		
		return screenshotpath;
		
	}
	
	public static void Webelement(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("arguments[0].click();",element);
		
	}

	
	
	public static String getCurrentDateTime() {
		DateFormat customer_format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date current_date = new Date();
		return customer_format.format(current_date);
		 
	}

}
