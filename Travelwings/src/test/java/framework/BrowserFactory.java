package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import utils.Constants;

public class BrowserFactory {
	
private static WebDriver driver;
	
public static WebDriver openBrowser(int testrow) {
	String browsername = ExcelUtils.getStringValue(testrow, Constants.browser_col);
	
	if(browsername.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	options.addArguments("window-size=1700x800");
	options.setHeadless(false);
	// if you set to false it open browser and we can see all the executions
	// if you set to true it open browser and we can not see any the executions
	
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

	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.get(Constants.url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	return driver;
}


}
