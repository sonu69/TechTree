package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.ExcelUtils;
import framework.Helper;
import framework.Waits;
import utils.Constants;

public class FlightSelect_Page {
	
	public static void flight_result(WebDriver driver,int testrow) throws InterruptedException {
		
		//Waits.ewait(driver, driver.findElement(By.xpath("//button[@class='bttn-search']")), 50);
		
		Thread.sleep(50000);
		
		for(int i=0;i<10;i++) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1000);
		}

		
		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[@class='bttn-search']"));
		
		String flightname = ExcelUtils.getStringValue(testrow, Constants.flightname_col);
				
		List <WebElement> flights_name= driver.findElements(By.xpath("//p[@class='travel-company-name ng-binding']"));
		
		boolean status = false;
		
		for(int j=0;j<flights_name.size();j++) {
			
			if(flightname.equalsIgnoreCase(flights_name.get(j).getText())) {
					
			Helper.Webelement(driver, select_buttons.get(j));
			status = true;
			break;
			
			}/*else if(j==flights_name.size()-1) {
				System.out.println("unable to find flight");
			}*/
			
		}
		
		if(!status) {
			
			System.out.println("unable to find flight");
		}
		
		
		
		
		
		
		
	}
	
	
	public static void add_flight(WebDriver driver) {
		
		List<WebElement> select_buttons = driver.findElements(By.xpath("//button[@class='bttn-search']"));
		
		select_buttons.get(0).click();
		
	}
	
	
	public static void select_flight(WebDriver driver,int testrow) throws InterruptedException {
		String status = ExcelUtils.getStringValue(testrow, Constants.preferred_airline);
		if(status.equalsIgnoreCase("yes")){
			FlightSelect_Page.add_flight(driver);
		}
		
		else {FlightSelect_Page.flight_result(driver, testrow);}
	
	}
	
	public static void fare_up(WebDriver driver) {
		
		WebElement continue_button = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		
		continue_button.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
