package framework;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.Addpax_Actions;
import actions.BookingDetail_Page;
import actions.FlightSelect_Page;
import actions.Payment_Actions;
import actions.Search_Inputs;
import pageObjects.Itinerary_Page;
import pageObjects.SearchFlight_Page;
import pageObjects.YourEmailId_Page;


public class Multicity {

	public static void main(String[] args) throws IOException, InterruptedException {
			
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://test.techtreeit.in");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//span[text()='Multi-city route']")).click();
				
				driver.findElement(By.xpath("//button[text()='Add City']")).click();
				
				List <WebElement> origins = driver.findElements(By.xpath("//input[contains(@id,'origin_')]"));
				List <WebElement> destinations = driver.findElements(By.xpath("//input[contains(@id,'destination_')]"));
				
//				for(int i=0;i<origins.size();i++) {
//				String origin = ExcelUtils.getStringValue(49+i, 1);
//				origins.get(i).clear();
//				origins.get(i).sendKeys(origin);				
//				SearchFlight_Page.elementlocator(driver, origin);
//				
//				}
				
				String origin = ExcelUtils.getStringValue(49, 1);
				origins.get(0).clear();
				origins.get(0).sendKeys(origin);				
				SearchFlight_Page.elementlocator(driver, origin);
				
				
				for(int i=0;i<destinations.size();i++) {
				String destination = ExcelUtils.getStringValue(49+i, 2);
				destinations.get(i).clear();
				destinations.get(i).sendKeys(destination);
				SearchFlight_Page.elementlocator(driver, destination);
				}

				Search_Inputs.journeydate(driver,50);
				
				Search_Inputs.pax_list(driver,50);
				
				Thread.sleep(2000);
				
				SearchFlight_Page.search_flight(driver).click();
				
				Thread.sleep(10000);
				
				FlightSelect_Page.add_flight(driver);
				
				Itinerary_Page.continue_itinerary(driver).click();
				
				YourEmailId_Page.account_login(driver,50);
				
				Addpax_Actions.execute(driver);
				
				Payment_Actions.payment_action(driver,50);

				BookingDetail_Page.booking_status(driver);
				
				BookingDetail_Page.booking_detail(driver);
						
	}
	

}
