package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	public static void hard_wait(int sec) throws InterruptedException{
		Thread.sleep(sec*1000);
	}
	
	public static void iwait(WebDriver driver, WebElement element, int second){
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}
	
	public static void ewait(WebDriver driver, WebElement element, int second) {
		WebDriverWait wait = new WebDriverWait(driver,second);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
