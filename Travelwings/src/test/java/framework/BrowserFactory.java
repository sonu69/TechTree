package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	
private static WebDriver driver;
	
public static WebDriver openBrowser() {
	String browsername = "chrome";
	
	if(browsername.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	options.addArguments("window-size=1700x800");
	
	//options.setHeadless(false);
	
	driver = new ChromeDriver(options);
	new DesiredCapabilities();
	DesiredCapabilities cap=DesiredCapabilities.chrome();
		
	} else if(browsername.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver");

		//FirefoxOptions options = new FirefoxOptions();
		//options.setHeadless(false);
		
		driver = new FirefoxDriver();
		new DesiredCapabilities();
		DesiredCapabilities cap=DesiredCapabilities.firefox();
	}
	
	return driver;
}
	

}
