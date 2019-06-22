package actions;

import org.openqa.selenium.WebDriver;

import framework.Waits;
import pageObjects.BookingConfirmation_Page;

public class BookingDetail_Page {
	
	public static void booking_status(WebDriver driver) {
		
		Waits.ewait(driver, BookingConfirmation_Page.status_message(driver), 1000);
		
		if(BookingConfirmation_Page.status_message(driver).getText().equalsIgnoreCase("Booking Confirmation")) {
			System.out.println("Booking success");
		}
		
		else if(BookingConfirmation_Page.status_message(driver).getText().equalsIgnoreCase("Booking Failed")) {
			System.out.println("Booking failed");
		}
		
	}
	
	
	public static void booking_detail(WebDriver driver) {
		
		String Reference_number = BookingConfirmation_Page.ref_num(driver).getText();
		System.out.println("Reference_number is- "+Reference_number);
		
		
		String Total = BookingConfirmation_Page.ttl_amt(driver).getText();
		System.out.println("Total amount is- "+Total);
			
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
