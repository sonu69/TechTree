package framework;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Flights {

	WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeClass
	public void bc() {
		driver=BrowserFactory.openBrowser();	 
	}
	
	@BeforeSuite
	public void setupsuite() {
		//ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/sonu"+Helper.getCurrentDateTime()+".html"));
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/sonu"+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Test
	public void flight() {	
		logger=report.createTest("Flight booking");	 
		logger.info("starting application");  
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://newuat.travelwings.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
}
