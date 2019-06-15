package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchFlight_Page {
	
	private static WebElement element;
	
	public static void elementlocator(WebDriver driver,String airportname) {
		element = driver.findElement(By.xpath("//div[@class='ctyname' and contains(text(),'"+airportname+"')]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		element.click();
	}
	
	public static WebElement origin(WebDriver driver) {
		element = driver.findElement(By.id("origin_0"));
		return element;
	}
	
	public static WebElement destination(WebDriver driver) {
		element = driver.findElement(By.id("destination_0"));
		return element;
	}
	
	public static WebElement journey_date(WebDriver driver) {
		element = driver.findElement(By.id("journeyDate_0"));
		return element;
	}
	
	public static WebElement return_date(WebDriver driver) {
		element = driver.findElement(By.id("returnDate_0"));
		return element;
	}
	
	
	public static WebElement journey_class(WebDriver driver,String cabinclass) {
		driver.findElement(By.id("onwardCabinClass")).click();
		
		if(cabinclass.equalsIgnoreCase("economy")) {
			element = driver.findElement(By.xpath("//input[@name='departCabinClass_0' and @value=\"Economy\"]"));
		}
		
		else if(cabinclass.equalsIgnoreCase("Premium")) {
			element = driver.findElement(By.xpath("//input[@name='departCabinClass_0' and @value=\"Premium\"]"));
		}
		
		else if(cabinclass.equalsIgnoreCase("Business")) {
			element = driver.findElement(By.xpath("//input[@name='departCabinClass_0' and @value=\"Business\"]"));
		}
		
		else if(cabinclass.equalsIgnoreCase("First Class")) {
			element = driver.findElement(By.xpath("//input[@name='departCabinClass_0' and @value=\"First Class\"]"));
		}
		
		return element;
	}
	
	
	public static WebElement return_class(WebDriver driver,String cabinclass) {
		driver.findElement(By.id("returnCabinClass")).click();
		
		if(cabinclass.equalsIgnoreCase("economy")) {
			element = driver.findElement(By.xpath("//input[@name='returnCabinClass_0' and @value=\"Economy\"]"));
		}
		
		else if(cabinclass.equalsIgnoreCase("Premium")) {
			element = driver.findElement(By.xpath("//input[@name='returnCabinClass_0' and @value=\"Premium\"]"));
		}
		
		else if(cabinclass.equalsIgnoreCase("Business")) {
			element = driver.findElement(By.xpath("//input[@name='returnCabinClass_0' and @value=\"Business\"]"));
		}
		
		else if(cabinclass.equalsIgnoreCase("First Class")) {
			element = driver.findElement(By.xpath("//input[@name='returnCabinClass_0' and @value=\"First Class\"]"));
		}
		
		return element;
	}
	
	
	public static WebElement pax(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='traveler-text']"));
		return element;
	}
	
	
	public static WebElement search_flight(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='bttn-primary']"));
		return element;
	}
	
	
	public static WebElement my_account(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@id='userName']"));
		return element;
	}
	
	
	public static WebElement login(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/login']"));
		return element;
	}
	
	
	public static WebElement sign_up(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/signup']"));
		return element;
	}
	
	public static WebElement advance_search(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='AdvacedSearch']"));
		return element;
	}
	
	

}
