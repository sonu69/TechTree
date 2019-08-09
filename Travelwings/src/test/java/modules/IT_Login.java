package modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IT_Login {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://192.168.1.10:1000/login??");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		 driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("sonu.kumar");
		 driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("sonu@321");
		 driver.findElement(By.xpath("//input[contains(@value,'Continue')]")).click();
		 
	}

}
