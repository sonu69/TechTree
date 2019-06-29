package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import framework.Helper;
import pageObjects.TravellerDetails_Page;

public class Addpax_Actions {
	
	public static void execute(WebDriver driver) throws IOException {
		
		TravellerDetails_Page.add_pax(driver);
		
	}
	
	public static void ssr(WebDriver driver,int testrow) throws IOException, InterruptedException {
		
		TravellerDetails_Page.onward_seatmap(driver,testrow);
		
		TravellerDetails_Page.return_seatmap(driver,testrow);
		
		TravellerDetails_Page.onward_baggage(driver, testrow);
		
		TravellerDetails_Page.return_baggage(driver, testrow);
		
		TravellerDetails_Page.onward_meal(driver, testrow);
		
		TravellerDetails_Page.return_meal(driver, testrow);
		
		Helper.Webelement(driver, TravellerDetails_Page.cont_button(driver));
		
	}
	

}
