package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test2 {
	
	static WebDriver driver;
	static WebElement element;
	
	public static void elementlocator(String airportname) {
		element = driver.findElement(By.xpath("//div[@class='ctyname' and contains(text(),'"+airportname+"')]"));
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		element.click();
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://newuat.travelwings.com/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String origin = "Ban";
		String destination = "Sharjah";
		
		driver.findElement(By.id("origin_0")).sendKeys(origin);
		Test2.elementlocator(origin);
		
		driver.findElement(By.id("destination_0")).sendKeys(destination);
		Test2.elementlocator(destination);

	}

}
