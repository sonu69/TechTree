package framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import actions.FlightSelect_Page;
import actions.Search_Inputs;
import pageObjects.Itinerary_Page;
import pageObjects.SearchFlight_Page;
import pageObjects.TravellerDetails_Page;
import pageObjects.YourEmailId_Page;

public class Meal_Baggage {

	public static void main(String[] args) throws IOException, InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://newuat.travelwings.com");
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
				
				FlightSelect_Page.select_flight(driver,TestCase_Row);
				
				Itinerary_Page.continue_itinerary(driver).click();
				
				YourEmailId_Page.account_login(driver,TestCase_Row);
				
				Thread.sleep(2000);
				
				TravellerDetails_Page.onward_seatmap(driver,TestCase_Row);
				
				TravellerDetails_Page.return_seatmap(driver,TestCase_Row);
				
				
				
				
		
		

	}

}
