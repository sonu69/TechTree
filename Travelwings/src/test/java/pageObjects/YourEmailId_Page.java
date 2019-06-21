package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.ExcelUtils;

public class YourEmailId_Page {
	
	private static WebElement element;
	
	public static WebElement guest_email(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='user-name']/input"));
		return element;
	}
	
	public static void account_login(WebDriver driver) throws IOException, InterruptedException {
		
		String username = ExcelUtils.getStringValue(1, 11);
		
		String password = ExcelUtils.getStringValue(1, 12);
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//input[@data-ng-model='booking.availableAccount.checked']")).click();
		driver.findElement(By.xpath("//input[@data-ng-click='booking.accountOpen()' or @data-ng-model='booking.availableAccount.checked']")).click();
		try {
		
		}
		catch (Exception e) {}
		
		try {
		driver.findElement(By.xpath("//div[@class='user-name']/input")).sendKeys(username);
		
		}catch (Exception e) {}
		
		try {
		
		driver.findElement(By.xpath("//div[@class='user-name ng-scope']/input")).sendKeys(password);
		}catch (Exception e) {}
		
		try {
		driver.findElement(By.xpath("//button[@id='submit-form']")).click();
		}catch (Exception e) {}
	}
	
	public static WebElement continue_btn(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='continue']/input"));
		return element;
	}
	

	
}
