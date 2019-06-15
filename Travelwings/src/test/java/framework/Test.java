package framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import actions.BookingDetail_Page;
import actions.FlightSelect_Page;
import actions.Payment_Actions;
import actions.Search_Inputs;
import pageObjects.Itinerary_Page;
import pageObjects.SearchFlight_Page;
import pageObjects.TravellerDetails_Page;
import pageObjects.YourEmailId_Page;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://test.techtreeit.in/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				String origin = "Delhi";
				String destination = "DXB";
				
				Search_Inputs.add_origin(driver, origin);
				Search_Inputs.add_destination(driver, destination);

				//Search_Inputs.journeydate(driver, "august", "25");
				
				String journey_month="July";
				String journey_date="18";
				Search_Inputs.journeydate(driver, journey_month, journey_date);
				
				//Search_Inputs.returndate(driver, "september", "29");
				
				String return_month="July";
				String return_date="24";
				Search_Inputs.returndate(driver, return_month, return_date);
				
				int adult = 1;
				int child = 0;
				int infants = 0;
				
				Search_Inputs.pax_list(driver, adult, child, infants);
				
				Search_Inputs.fligh_tname(driver, "Etihad");
				
				Thread.sleep(2000);
				
				SearchFlight_Page.search_flight(driver).click();
				
				Thread.sleep(10000);
				
				FlightSelect_Page.select_flight(driver);
				
				//IndiGo Airlines
				//Emirates
				//Etihad
				//Oman Air
				
				Itinerary_Page.continue_itinerary(driver).click();
				
				YourEmailId_Page.account_login(driver, "sonu.kumar@techtreeit.com", "sonu3791");
				
				TravellerDetails_Page.add_passengers(driver);
				
				TravellerDetails_Page.cont_button(driver).click();
				
				Payment_Actions.payment_action(driver);
				
				BookingDetail_Page.booking_status(driver);
				
				BookingDetail_Page.booking_detail(driver);


	}

}

//https://sqa.stackexchange.com/questions/10342/how-to-find-element-using-contains-in-xpath
