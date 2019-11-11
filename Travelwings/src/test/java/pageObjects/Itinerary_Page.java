package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Itinerary_Page {
	
	private static WebElement element;
	
	public static WebElement continue_itinerary(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[contains(@class,'bttn-yellow yellow-button')]"));
		//element = driver.findElement(By.xpath("//button[contains(@class,'bttn-yellow yellow-button') and contains(text(),'CONTINUE')]"));
		
		
		return element;
	}
	
}
