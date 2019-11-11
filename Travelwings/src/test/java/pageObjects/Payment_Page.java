package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Payment_Page {
	
	private static WebElement element;
	
	public static WebElement card_number(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='newcardno']"));
		return element;
	}
	
	public static WebElement card_name(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='cardHolderName']"));
		return element;
	}
	
	
	public static WebElement card_cvv(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='cvvNumber']"));
		return element;
	}
	
	public static void exp_month(WebDriver driver,String month) {
		Select exp_month = new Select(driver.findElement(By.xpath("//select[@data-ng-model='booking.carExpMonth']")));
		exp_month.selectByVisibleText(month);
	}
	
	public static void exp_year(WebDriver driver,String year) {
		Select exp_year= new Select(driver.findElement(By.xpath("//select[@name='expYear']")));
		exp_year.selectByVisibleText(year);
	}
	
	
	public static WebElement agreement_checkbox(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='box']/input[@name='checkbox']"));
		return element;
	}
	
	public static WebElement payment_submit(WebDriver driver) {
		
		//element = driver.findElement(By.xpath("//div[@class='col-md-3 padding-zero']/button[@class='bttn-yellow']"));
		
		element = driver.findElement(By.xpath("//button[contains(text(),'MAKE PAYMENT')]"));
		
		return element;
	}
	

}
