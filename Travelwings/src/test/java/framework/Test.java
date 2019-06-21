package framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import actions.Addpax_Actions;
import actions.BookingDetail_Page;
import actions.FlightSelect_Page;
import actions.Payment_Actions;
import actions.Search_Inputs;
import pageObjects.Itinerary_Page;
import pageObjects.SearchFlight_Page;
import pageObjects.TravellerDetails_Page;
import pageObjects.YourEmailId_Page;

public class Test {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://test.techtreeit.in/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				Search_Inputs.add_origin(driver);
				Search_Inputs.add_destination(driver);

				//Search_Inputs.journeydate(driver, "august", "25");
				
				String journey_month="July";
				String journey_date="18";
				Search_Inputs.journeydate(driver, journey_month, journey_date);
				
				//Search_Inputs.returndate(driver, "september", "29");
				
				String return_month="July";
				String return_date="24";
				Search_Inputs.returndate(driver, return_month, return_date);
				
				Search_Inputs.pax_list(driver);
				
				Search_Inputs.flight_name(driver);
				
				Thread.sleep(2000);
				
				SearchFlight_Page.search_flight(driver).click();
				
				Thread.sleep(10000);
				
				FlightSelect_Page.select_flight(driver);
				
				Itinerary_Page.continue_itinerary(driver).click();
				
				YourEmailId_Page.account_login(driver);
				
				Addpax_Actions.execute(driver);
				
				Payment_Actions.payment_action(driver);

				BookingDetail_Page.booking_status(driver);
				
				BookingDetail_Page.booking_detail(driver);


	}

}

//https://sqa.stackexchange.com/questions/10342/how-to-find-element-using-contains-in-xpath
