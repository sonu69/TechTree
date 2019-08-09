package modules;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import actions.Search_Inputs;
import framework.ExcelUtils;
import utils.Constants;

public class Affiliate_Website {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		 System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://test.techtreeit.in//affiliatewidgets/widget/AFT112");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Actions act = new Actions(driver);

		 int TestCase_Row=ExcelUtils.getRowContains(Constants.testcase_name);
		 
		 String origin = "Delhi";
		 driver.findElement(By.xpath("//input[@id='origin_0']")).sendKeys(origin);
		 List <WebElement> element = driver.findElements(By.xpath("//div[@class='ctyname' and contains(text(),'"+origin+"')]"));
		 act.moveToElement(element.get(0)).click().build().perform();
		 
		 String destination="Dubai";
		 driver.findElement(By.xpath("//input[@id='destination_0']")).sendKeys(destination);
		 act.keyDown(Keys.CONTROL).click(driver.findElements(By.xpath("//div[contains(text(),'"+destination+"')]")).get(0)).build().perform();
 
		
		
		 
		 
	}

}
