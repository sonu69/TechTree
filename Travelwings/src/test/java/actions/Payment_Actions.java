package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.Payment_Page;

public class Payment_Actions {
	
	public static void add_cardnumber(WebDriver driver, String number) {
		Payment_Page.card_number(driver).sendKeys(number);
		
	}
	
	public static void add_cardname(WebDriver driver, String number) {
		Payment_Page.card_name(driver).sendKeys(number);
		
	}
	
	public static void add_cvv(WebDriver driver, String cvv) {
		Payment_Page.card_cvv(driver).sendKeys(cvv);
		
	}
	
	
	public static void add_expmonth(WebDriver driver, String month) {
		Payment_Page.exp_month(driver, month);
	}
	
	
	public static void add_expyear(WebDriver driver, String year) {
		Payment_Page.exp_year(driver, year);
	}
	
	
	public static void check_agrement(WebDriver driver) {
		Payment_Page.agreement_checkbox(driver);
	}
	
	
	public static void makepayment(WebDriver driver) {
		Payment_Page.payment_submit(driver);
	}

	public static void payment_action(WebDriver driver) {
		Payment_Page.card_number(driver).sendKeys("4000000000000051");
		Payment_Page.card_name(driver).sendKeys("John doe");
		Payment_Page.card_cvv(driver).sendKeys("111");
		Payment_Page.exp_month(driver, "12");
		Payment_Page.exp_year(driver, "2020");
		Payment_Page.agreement_checkbox(driver).click();
		Payment_Page.payment_submit(driver).click();
		
		
	}
	
}
