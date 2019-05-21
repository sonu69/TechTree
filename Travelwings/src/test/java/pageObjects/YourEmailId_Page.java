package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourEmailId_Page {
	
	private static WebElement element;
	
	public static WebElement guest_email(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='user-name']/input"));
		return element;
	}
	
	
	public static WebElement account_login(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@data-ng-model=\"booking.availableAccount.checked\"]"));
		
		return element;
	}
	
	

}
