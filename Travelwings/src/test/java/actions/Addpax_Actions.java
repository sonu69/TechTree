package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.TravellerDetails_Page;

public class Addpax_Actions {
	
	public static void execute(WebDriver driver) throws IOException {
		
		TravellerDetails_Page.add_pax(driver);
		
	}
	
	public static void seat_execute(WebDriver driver) throws IOException, InterruptedException {
		
		TravellerDetails_Page.onward_seatmap(driver);
		
		TravellerDetails_Page.return_seatmap(driver);
		
		TravellerDetails_Page.cont_button(driver).click();
		
	}
	

}
