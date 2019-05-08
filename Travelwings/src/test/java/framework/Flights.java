package framework;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Flights {

	@Test
	public void flight() {	
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		//System.setProperty("webdriver.chrome.driver", ".//chromedriver");
		ChromeOptions options = new ChromeOptions();  
		//options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
		options.setHeadless(false);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://newuat.travelwings.com/");
		
	}
	
	
}
