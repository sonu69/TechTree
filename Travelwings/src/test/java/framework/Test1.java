package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actions.Addpax_Actions;
import actions.BookingDetail_Page;
import actions.FlightSelect_Page;
import actions.Payment_Actions;
import actions.Search_Inputs;
import pageObjects.Itinerary_Page;
import pageObjects.SearchFlight_Page;
import pageObjects.YourEmailId_Page;
import utils.Constants;

public class Test1 {
	
	public static void main (String[] args) throws Exception {
		
		int TestCase_Row=ExcelUtils.getRowContains(Constants.testcase_name);
		
		WebDriver driver = BrowserFactory.openBrowser(TestCase_Row);
		
		//ChangeCountry_Page.change_country(driver, TestCase_Row).click();
				
		//ChangeCountry_Page.change_currency(driver, TestCase_Row).click();
		
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
		
		Thread.sleep(1000);
		
		WebElement continue_button = driver.findElement(By.xpath("//div[@class='text-right continue']/button[text()='CONTINUE']"));

		//driver.findElements(By.xpath("//button[text()='CONTINUE']")).get(0).click();

		Helper.Webelement(driver, Itinerary_Page.continue_itinerary(driver));
		
		Thread.sleep(1000);
		
		YourEmailId_Page.account_login(driver,TestCase_Row);
		
		Thread.sleep(2000);
		
		Addpax_Actions.execute(driver);
		
		Thread.sleep(5000);
		
		Addpax_Actions.ssr(driver,TestCase_Row);
		
		System.exit(0);
		
		Payment_Actions.payment_action(driver, TestCase_Row);

		BookingDetail_Page.booking_status(driver);
		
		BookingDetail_Page.booking_detail(driver);

	}
}