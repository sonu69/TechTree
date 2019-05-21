package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.ChangeCountry_Page;
import pageObjects.Login_Page;
import pageObjects.SearchFlight_Page;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://test.techtreeit.in/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				


	}

}
