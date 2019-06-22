package framework;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.SearchFlight_Page;


public class Multicity {

	public static void main(String[] args) throws IOException {
		 
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://test.techtreeit.in/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//span[text()='Multi-city route']")).click();
				
				driver.findElement(By.xpath("//button[text()='Add City']")).click();
				
				List <WebElement> origins = driver.findElements(By.xpath("//input[contains(@id,'origin_')]"));
				List <WebElement> destinations = driver.findElements(By.xpath("//input[contains(@id,'destination_')]"));
				List <WebElement> journeydate = driver.findElements(By.xpath("//input[contains(@id,'journeyDate_')]"));
				
				
				for(int i=0;i<destinations.size();i++) {
				String destination = ExcelUtils.getStringValue(49+i, 2);
				destinations.get(i).clear();
				destinations.get(i).sendKeys(destination);
				SearchFlight_Page.elementlocator(driver, destination);
				
				}
				
				for(int i=0;i<origins.size();i++) {
				String origin = ExcelUtils.getStringValue(49+i, 1);
				origins.get(i).clear();
				origins.get(i).sendKeys(origin);
				SearchFlight_Page.elementlocator(driver, origin);
				}
				
				
				for(int i=0;i<journeydate.size();i++) {
					String journeydat = ExcelUtils.getStringValue(49+i, 3);
					journeydate.get(i).click();
					
				}
				

				
				
				
				
				
	
		

	}

}
