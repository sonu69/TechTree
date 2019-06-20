package framework;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import actions.FlightSelect_Page;
import actions.Search_Inputs;
import pageObjects.Itinerary_Page;
import pageObjects.SearchFlight_Page;
import pageObjects.YourEmailId_Page;

public class Test2 {
	
	static WebDriver driver;
	static WebElement element;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://newuat.travelwings.com");
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
				
				int adult = 2;
				int child = 2;
				int infants = 2;
				
				Search_Inputs.pax_list(driver, adult, child, infants);
				
				Search_Inputs.fligh_tname(driver, "Etihad");
				
				Thread.sleep(10000);
				
				SearchFlight_Page.search_flight(driver).click();
				
				Thread.sleep(10000);
				FlightSelect_Page.select_flight(driver);
				//IndiGo Airlines
				//Emirates
				//Etihad
				//Oman Air
				Itinerary_Page.continue_itinerary(driver).click();	
				
				Thread.sleep(5000);
				
				YourEmailId_Page.account_login(driver, "sonu.kumar@techtreeit.com", "sonukumar");
				
				
//				driver.findElement(By.xpath("//div[@class='user-name']/input")).sendKeys("sonu.kumar@techtreeit.com");
//				
//				driver.findElement(By.xpath("//button[@id='submit-form']")).click();
				
				Test3.add_pax();
	
	}
				
	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	}


