package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test4 {

	static WebDriver driver;
	static WebElement element;

	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://newuat.travelwings.com/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//input[@id='origin_0']")).sendKeys("del");
				
				Actions act = new Actions(driver);
				act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//div[@class='ctyname' and contains(text(),'Maldonado')]"))).build().perform();
				

	}

}

//http://www.qualitylearning.in/?p=1823