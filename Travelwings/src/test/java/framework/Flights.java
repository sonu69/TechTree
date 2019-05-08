package framework;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flights {

	@Test
	public void flight() {	
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://newuat.travelwings.com/");
		
	}
	
	
}
