package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.BookingConfirmation_Page;

public class Booking_Actions {
	
	
	public static void booking_status(WebDriver driver) {
		
		if(BookingConfirmation_Page.status_message(driver).getText().equalsIgnoreCase("Booking Confirmation")) {
			System.out.println("Booking success");
		}
		
		else if(BookingConfirmation_Page.status_message(driver).getText().equalsIgnoreCase("Booking Failed")) {
			System.out.println("Booking failed");
		}
		
	}
	
	public static void reference_number(WebDriver driver) {
		String ref = BookingConfirmation_Page.ref_num(driver).getText();
		System.out.println("Reference Booking number is- "+ref);
	}
	
	
	public static void total_amount(WebDriver driver) {
		String Total = BookingConfirmation_Page.ttl_amt(driver).getText();
		System.out.println("Total amount is- "+Total);
	}
	

}
