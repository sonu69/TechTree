package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.ExcelUtils;

public class FlightSelect_Page {
	
	public static void select_flight(WebDriver driver,int testrow) {
		
		String flightname = ExcelUtils.getStringValue(testrow, 8);
		
		List<WebElement> flights=driver.findElements(By.xpath("//p[@class='travel-company-name ng-binding']"));
		
		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[@class='bttn-search']"));
		
		for(int j=0;j<flights.size();j++) {

			if(flights.get(j).getText().equalsIgnoreCase(flightname)) {
				select_buttons.get(j).click();
				break;
			}	
		}
	}

	
	
	public static void select_flight(WebDriver driver) {
		
		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[@class='bttn-search']"));
		
		select_buttons.get(0).click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
