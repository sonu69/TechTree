package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightSelect_Page {
	
	private static WebElement element;
	
	public static void select_flight(WebDriver driver,String flight_name) {
		
		List<WebElement> flights=driver.findElements(By.xpath("//p[@class='travel-company-name ng-binding']"));
		
		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[@class='bttn-search']"));
		
		for(int j=0;j<flights.size();j++) {

			if(flights.get(j).getText().equalsIgnoreCase("IndiGo Airlines")) {
				select_buttons.get(j).click();
				break;
			}
			
			else if(flights.get(j).getText().equalsIgnoreCase("Spicejet")) {
				select_buttons.get(j).click();
				break;
			}
			
			else if(flights.get(j).getText().equalsIgnoreCase("Emirates")) {
				select_buttons.get(j).click();
				break;
			}
			
			else if(flights.get(j).getText().equalsIgnoreCase("Etihad")) {
				select_buttons.get(j).click();
				break;
			}
			
			else if(flights.get(j).getText().equalsIgnoreCase("Air Indiaexpress")) {
				select_buttons.get(j).click();
				break;
			}
			
			else if(flights.get(j).getText().equalsIgnoreCase("IndiGo Airlines")) {
				select_buttons.get(j).click();
				break;
			}
			
			
			
			
		}

	}

}
