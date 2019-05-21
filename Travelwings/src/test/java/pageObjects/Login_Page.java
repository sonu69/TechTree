package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	
	private static WebElement element;
	
	public static WebElement username(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='userAlias']"));
		return element;
	}
	
	public static WebElement password(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='password']"));
		return element;
	}
	
	public static WebElement remeber_me(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='checksquare']"));
		return element;
	}
	
	public static WebElement submit(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[text()='Login']"));
		return element;
	}
	
	public static WebElement forgot_password(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[text()='Forgot Password?']"));
		return element;
	}
	
	

}
