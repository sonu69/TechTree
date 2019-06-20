package framework;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test3 {
	
	static WebDriver driver;
	static WebElement element;


	public void selectOptionWithText(String textToSelect) {
		try {
			WebElement autoOptions = driver.findElement(By.xpath("//div[@class='ctyname']"));
			WebDriverWait wait = new WebDriverWait (driver,10);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.xpath(""));
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	

	public static void main(String[] args) throws IOException {
		
		System.out.println(ExcelUtils.getStringValue(17, 0));
		
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
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
