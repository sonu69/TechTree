package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Itinerary_Page {
	
	private static WebElement element;
	
	public static WebElement continue_itinerary(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()='CONTINUE' and @class='bttn-yellow yellow-button ng-scope']"));
		
		return element;
	}
	

}
