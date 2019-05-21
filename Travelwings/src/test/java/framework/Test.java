package framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.FlightSelect_Page;
import actions.Search_Inputs;
import pageObjects.ChangeCountry_Page;
import pageObjects.Itinerary_Page;
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
				
				driver.findElement(By.id("origin_0")).sendKeys("del");
				Actions act = new Actions(driver);
				
				WebElement origin_add=driver.findElement(By.xpath("//div[@class='ctyname' and text()='New Delhi (DEL)']"));
				act.moveToElement(origin_add).build().perform();
				origin_add.click();
				
				driver.findElement(By.id("destination_0")).sendKeys("dxb");
				WebElement dest_add=driver.findElement(By.xpath("//div[@class='ctyname' and text()='Dubai (DXB)']"));
				act.moveToElement(dest_add).build().perform();
				dest_add.click();
				
	
				Search_Inputs.journeydate(driver, "august", "25");
				
				Search_Inputs.returndate(driver, "september", "29");
				
				
				Search_Inputs.pax_list(driver, 2, 2, 2);
				
				Thread.sleep(2000);
				
				WebElement lets_play=driver.findElement(By.xpath("//button[@class='bttn-primary']"));

				Waits.ewait(driver, lets_play,10);
				
				lets_play.click();
				
				FlightSelect_Page.select_flight(driver, "Spicejet");
				
				Itinerary_Page.continue_itinerary(driver).click();
				
				
				
				

				
				
				
				
				


	}

}
