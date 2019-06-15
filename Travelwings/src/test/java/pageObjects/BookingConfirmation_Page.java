package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingConfirmation_Page {
	
	
private static WebElement element;
	

	public static WebElement status_message(WebDriver driver) {
		element = driver.findElement(By.xpath("//div/h3[@class='book-confirm-title ng-binding']"));
		return element;
	}
	
	
	public static WebElement ref_num(WebDriver driver) {
		element = driver.findElement(By.xpath("//b[@data-ng-bind='booking.fbRefrenceNo']"));
		return element;
	}
	
	
	public static WebElement ttl_amt(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='amount']/span[@class='ng-binding']"));
		return element;
	}

	
	
}
