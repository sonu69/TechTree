package framework;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import actions.Addpax_Actions;
import actions.FlightSelect_Page;
import actions.Search_Inputs;
import pageObjects.ChangeCountry_Page;
import pageObjects.Itinerary_Page;
import pageObjects.SearchFlight_Page;
import pageObjects.TravellerDetails_Page;
import pageObjects.YourEmailId_Page;

public class Seat_Selection {

	static WebDriver driver;
	static WebElement element;

	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://test.techtreeit.in");
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		int TestCase_Row=ExcelUtils.getRowContains("TestCase_LCC1");
				
				Search_Inputs.add_origin(driver,TestCase_Row);
				
				Search_Inputs.add_destination(driver,TestCase_Row);

				Search_Inputs.journeydate(driver,TestCase_Row);
				
				Search_Inputs.returndate(driver,TestCase_Row);
				
				Search_Inputs.pax_list(driver,TestCase_Row);
				
				Search_Inputs.flight_name(driver,TestCase_Row);
				
				Thread.sleep(2000);
				
				SearchFlight_Page.search_flight(driver).click();
				
				Thread.sleep(10000);
				
				FlightSelect_Page.select_flight(driver);
				
				Itinerary_Page.continue_itinerary(driver).click();
				
				YourEmailId_Page.account_login(driver,TestCase_Row);
				
				Thread.sleep(2000);
				
				Addpax_Actions.execute(driver);
				
				Thread.sleep(2000);
				
				//List <WebElement> on_seat=driver.findElements(By.xpath("//button[contains(text(),'Onward Seat')]"));
				
				String onwrd_seat = ExcelUtils.getStringValue(1, 11);
				
				if(onwrd_seat.equalsIgnoreCase("YES") ) {
				
				List <WebElement> on_seat=driver.findElements(By.xpath("//button[contains(@data-ng-click,'booking.openSelectModal')]"));
				
				//on_seat.get(0).click();
				
				WebElement element = driver.findElements(By.xpath("//button[contains(@data-ng-click,'booking.openSelectModal')]")).get(0);
				JavascriptExecutor js = (JavascriptExecutor) driver;		
				js.executeScript("arguments[0].click();",element);
				
				
				List<WebElement> Adult_onward = driver.findElements(By.xpath("//input[contains(@id,'change_')]"));
				
				List <WebElement> seat_select = driver.findElements(By.xpath("//li[contains(@id,'onward_') and @class='available']"));
				Thread.sleep(2000);
				
				Adult_onward.get(0).click();
				seat_select.get(0).click();
				
				Thread.sleep(2000);
				Adult_onward.get(1).click();
				seat_select.get(1).click();	
				
				Thread.sleep(2000);
				Adult_onward.get(2).click();
				seat_select.get(2).click();
				
				Thread.sleep(2000);
				Adult_onward.get(3).click();
				seat_select.get(3).click();
				
				Thread.sleep(2000);
				
				driver.findElements(By.xpath("//div[@class='text-right']/a[text()='Confirm & Continue']")).get(0).click();
				
				}
				
				
				Thread.sleep(2000);
				
				String rt_seat = ExcelUtils.getStringValue(1, 12);
				
				String date = ExcelUtils.getStringValue(1, 4);
				
				if(rt_seat.equalsIgnoreCase("YES") &&  !"".equals(date)) {
					
				List <WebElement> on_seat=driver.findElements(By.xpath("//button[contains(@data-ng-click,'booking.openSelectModal')]"));
					
				WebElement element = driver.findElements(By.xpath("//button[contains(@data-ng-click,'booking.openSelectModal')]")).get(1);
				JavascriptExecutor js = (JavascriptExecutor) driver;		
				js.executeScript("arguments[0].click();",element);
				
				
				//on_seat.get(1).click();
				
				List<WebElement> Adult_return = driver.findElements(By.xpath("//input[contains(@id,'changeR_0')]"));
				
				List <WebElement> retun_seat = driver.findElements(By.xpath("//li[contains(@id,'return_') and @class='available']"));
				Thread.sleep(2000);
				
				Adult_return.get(0).click();
				retun_seat.get(0).click();
				
				Thread.sleep(2000);
				Adult_return.get(1).click();
				retun_seat.get(1).click();	
				
				Thread.sleep(2000);
				Adult_return.get(2).click();
				retun_seat.get(2).click();
				
				Thread.sleep(2000);
				Adult_return.get(3).click();
				retun_seat.get(3).click();
				
				Thread.sleep(2000);
				driver.findElements(By.xpath("//div[@class='text-right']/a[text()='Confirm & Continue']")).get(1).click();
				}
				
				TravellerDetails_Page.cont_button(driver).click();

	}
}

//http://www.qualitylearning.in/?p=1823