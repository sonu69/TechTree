package framework;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
	
	static WebDriver driver;
	static WebElement element;

	public static void main(String[] args) throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://newuat.travelwings.com/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//input[@id='origin_0']")).sendKeys("del");
				
				List <WebElement> li = driver.findElements(By.xpath("//div[@class='ctyname']"));

				for(int i=0; i < li.size();i++) {
				
					if (li.get(i).getText().contains("Maldonado")) {
						
						li.get(i).click();
					}
				
				
				}

	}

}
