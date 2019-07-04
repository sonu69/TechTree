package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.ExcelUtils;
import framework.Helper;
import utils.Constants;

public class FlightSelect_Page {
	
	public static void flight_result(WebDriver driver,int testrow) {
		
		for(int i=0;i<50;i++) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		
		List<WebElement> flights=driver.findElements(By.xpath("//p[@class='travel-company-name ng-binding']"));
		
		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[@class='bttn-search']"));
		
		String flightname = ExcelUtils.getStringValue(testrow, Constants.flightname_col);
				
		for(int j=0;j<flights.size();j++) {

			if(flights.get(j).getText().equalsIgnoreCase(flightname)) {
				Helper.Webelement(driver, select_buttons.get(j));
				break;
			}
			else {
			}
		}
	}
	
	
	public static void add_flight(WebDriver driver) {
		
		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[@class='bttn-search']"));
		
		select_buttons.get(0).click();
		
	}
	
	public static void select_flight(WebDriver driver,int testrow) {
		String status = ExcelUtils.getStringValue(testrow, Constants.preferred_airline);
		if(status.equalsIgnoreCase("yes")){
			FlightSelect_Page.add_flight(driver);
		}
		
		else {FlightSelect_Page.flight_result(driver, testrow);}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
