package modules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Robot_Class {

	public static void main(String[] args) throws InterruptedException, AWTException {
		 System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://test.techtreeit.in/twnc/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 Actions act = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 
		 
		 js.executeScript("arguments[0].value='twadmin'",driver.findElement(By.xpath("//input[@id='userAlias']")));
		 //driver.findElement(By.xpath("//input[@id='userAlias']")).sendKeys("twadmin");
		 
		 //js.executeScript("arguments[0].value='twadmin'",driver.findElement(By.xpath("//input[@id='password_password']")));
		 driver.findElement(By.xpath("//input[@id='password_password']")).sendKeys("twadmin");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//input[@id='login_id']")).click();

		 driver.findElement(By.xpath("//li[@id='Affiliate']")).click();
		 
		 driver.findElement(By.xpath("//a[@id='add_click']")).click();
		 
		 driver.findElement(By.id("file_0")).click();
		 
		 Robot rb = new Robot();
		 rb.keyPress(KeyEvent.VK_TAB);
		 rb.keyPress(KeyEvent.VK_TAB);
		 rb.keyPress(KeyEvent.VK_TAB);
		 
		 rb.keyPress(KeyEvent.VK_ENTER);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

	}

}
