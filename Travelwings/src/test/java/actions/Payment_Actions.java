package actions;

import org.openqa.selenium.WebDriver;

import framework.ExcelUtils;
import pageObjects.Payment_Page;
import utils.Constants;

public class Payment_Actions {
	
	public static void add_cardnumber(WebDriver driver, int testrow) {
		String number = ExcelUtils.getStringValue(testrow, Constants.card_number_col);
		Payment_Page.card_number(driver).sendKeys(number);
		
	}
	
	public static void add_cardname(WebDriver driver, int testrow) {
		String name = ExcelUtils.getStringValue(testrow, Constants.card_name_col);
		Payment_Page.card_name(driver).sendKeys(name);
		
	}
	
	public static void add_cvv(WebDriver driver, int testrow) {
		String cvv = ExcelUtils.getStringValue(testrow, Constants.cvv_col);
		Payment_Page.card_cvv(driver).sendKeys(cvv);
		
	}
	
	
	public static void add_expmonth(WebDriver driver,int testrow ) {
		String month = ExcelUtils.getStringValue(testrow, Constants.exp_month_col);
		Payment_Page.exp_month(driver, month);
	}
	
	
	public static void add_expyear(WebDriver driver, int testrow ) {
		String year = ExcelUtils.getStringValue(testrow, Constants.exp_year_col);
		Payment_Page.exp_year(driver, year);
	}
	
	
	public static void check_agrement(WebDriver driver) {
		Payment_Page.agreement_checkbox(driver).click();
	}
	
	
	public static void makepayment(WebDriver driver) {
		Payment_Page.payment_submit(driver).click();
	}

	public static void payment_action(WebDriver driver,int testrow) {
		Payment_Actions.add_cardnumber(driver,testrow);
		Payment_Actions.add_cardname(driver,testrow);
		Payment_Actions.add_cvv(driver,testrow);
		Payment_Actions.add_expmonth(driver,testrow);
		Payment_Actions.add_expyear(driver, testrow);
		Payment_Actions.check_agrement(driver);
		Payment_Actions.makepayment(driver);
	}
	
	
//	public static void payment_action(WebDriver driver) {
//		Payment_Page.card_number(driver).sendKeys("4000000000000051");
//		Payment_Page.card_name(driver).sendKeys("John doe");
//		Payment_Page.card_cvv(driver).sendKeys("111");
//		Payment_Page.exp_month(driver, "12");
//		Payment_Page.exp_year(driver, "2020");
//		Payment_Page.agreement_checkbox(driver).click();
//		Payment_Page.payment_submit(driver).click();
//	}
	
}
