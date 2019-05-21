package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchFlight_Page {
	
	private static WebElement element;
	
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
		element = driver.findElement(By.id("journeyDate_0"));
		return element;
	}
	
	public static WebElement journey_class(WebDriver driver) {
		element = driver.findElement(By.id("journeyDate_0"));
		return element;
	}
	
	public static WebElement return_class(WebDriver driver) {
		element = driver.findElement(By.id("journeyDate_0"));
		return element;
	}
	
	public static WebElement passenger(WebDriver driver) {
		element = driver.findElement(By.id("journeyDate_0"));
		return element;
	}
	
	public static WebElement search_flight(WebDriver driver) {
		element = driver.findElement(By.id("journeyDate_0"));
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
	
	
	
	

}
