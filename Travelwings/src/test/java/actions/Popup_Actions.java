package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.PriceIncrease_Popup;

public class Popup_Actions {
	
	
	public static void handle_price(WebDriver driver) {
		try{
			PriceIncrease_Popup.continue_price(driver).click();
		}
		catch(Exception e) {
			System.out.println("price has not changed");
		} 
	}
}
	
	
	
