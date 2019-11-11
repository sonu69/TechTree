package framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.Addpax_Actions;
import actions.BookingDetail_Page;
import actions.FlightSelect_Page;
import actions.Payment_Actions;
import actions.Search_Inputs;
import pageObjects.ChangeCountry_Page;
import pageObjects.Itinerary_Page;
import pageObjects.SearchFlight_Page;
import pageObjects.YourEmailId_Page;
import utils.Constants;

public class Test {

	public static void main(String[] args) throws InterruptedException, IOException {

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
								
		SearchFlight_Page.search_flight(driver).click();
				
		FlightSelect_Page.flight_result(driver,TestCase_Row);
		
		try {
		if(driver.findElement(By.xpath("//h4[@class='modal-title ng-binding ng-scope']")).isDisplayed()==true) {
			
			WebElement continue_button = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
			
			continue_button.click();
			
		} 
		
		}
		catch (Exception e){e.getMessage();}

		Thread.sleep(1000);
		
		Itinerary_Page.continue_itinerary(driver).click();
		
		Thread.sleep(1000);
		
		YourEmailId_Page.account_login(driver,TestCase_Row);
		
		Thread.sleep(2000);
		
		Addpax_Actions.execute(driver);
		
		Thread.sleep(5000);
		
		Addpax_Actions.ssr(driver,TestCase_Row);
		
		Payment_Actions.payment_action(driver, TestCase_Row);

		BookingDetail_Page.booking_status(driver);
		
		BookingDetail_Page.booking_detail(driver);

	}

}

//https://sqa.stackexchange.com/questions/10342/how-to-find-element-using-contains-in-xpath
