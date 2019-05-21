package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriceIncrease_Popup {
	
	private static WebElement element;
	
	public static WebElement continue_price(WebDriver driver) {
		element=driver.findElement(By.xpath("//h4[@class='modal-title ng-binding ng-scope']"));
		return element;
	}
	
	
	public static WebElement cancel_price(WebDriver driver) {
		element=driver.findElement(By.xpath("//h4[@class='modal-title ng-binding ng-scope']"));
		return element;
	}
	
	

}
