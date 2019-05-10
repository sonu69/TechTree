package framework;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/sonu"+Helper.getCurrentDateTime()+".html"));
		//ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/sonu"+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Test
	public void flight() throws Exception {
		logger=report.createTest("Flight booking");	 
		logger.info("starting application");  
		
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
		
		driver.findElement(By.id("journeyDate_0")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		String departing_month="September";
		String departing_day="23";

		String month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
		
		if(month.equalsIgnoreCase(departing_month)) {
			System.out.println("month selected");	
		}else {
			for(int i=1;i<12;i++) {
				WebElement next_month=driver.findElement(By.xpath("//body[@class='ng-scope']/div[3]/div[2]/div/a[@title='Next']"));				
				wait.until(ExpectedConditions.elementToBeClickable(next_month));
				next_month.click();				month=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).get(0).getText();
		if(month.equalsIgnoreCase(departing_month)){
					break;
}}}		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td")));
		List<WebElement> enable_days = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody/tr/td"));
		for(int j=0;j<enable_days.size();j++)
			{
			if(enable_days.get(j).getText().equalsIgnoreCase(departing_day))
				{
				enable_days.get(j).click();
				}
			}
		
		 
		WebElement traveller = driver.findElement(By.xpath("//span[@class='traveler-text']"));
		traveller.click();
		
		int a = 1;
		int c=0;
		int i=0;
		
		for(int n=1;n<a;n++){
			WebElement adult_count=driver.findElement(By.xpath("//button[@data-ng-click='flight.addAdult()']"));
			adult_count.click();
		}

		for(int o=1;o<=c;o++){
			WebElement child_count=driver.findElement(By.xpath("//button[@data-ng-click='flight.addChild()']"));
			child_count.click();
		}
		
		for(int p=1;p<a;p++){
			WebElement infant_count=driver.findElement(By.xpath("//button[@data-ng-click='flight.addInfant()']"));
			infant_count.click();
		}
			
		WebElement cancel_traveller=driver.findElement(By.xpath("//div[@class='cancel']/div"));
		cancel_traveller.click();
		
		Thread.sleep(2000);
		
		WebElement lets_play=driver.findElement(By.xpath("//button[@class='bttn-primary']"));

		Waits.ewait(driver, lets_play,10);
		
		lets_play.click();
		
		Thread.sleep(5000);
		
		List<WebElement> flights=driver.findElements(By.xpath("//p[@class='travel-company-name ng-binding']"));
		
		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[@class='bttn-search']"));
		
		for(int j=0;j<flights.size();j++) {

			if(flights.get(j).getText().equalsIgnoreCase("IndiGo Airlines")) {
				select_buttons.get(j).click();
				break;
			}
		}

	Thread.sleep(5000);
	
	//WebElement continue_popup=driver.findElement(By.xpath("//button[@class='btn bttn-yellow yellow-bttn ng-binding']"));
	//WebElement continue_popup=driver.findElement(By.xpath("//div[@class='col-md-6']"));
	//WebElement continue_popup=driver.findElement(By.xpath("//button[@class='btn bttn-grey-bg ng-binding']"));
	
	try {
	
		WebElement continue_popup=driver.findElement(By.xpath("//h4[@class='modal-title ng-binding ng-scope']"));
		continue_popup.click();
	}
	catch(Exception e) {
		System.out.println("price has not changed");
	}
	
	driver.findElement(By.xpath("//button[text()='CONTINUE' and @class='bttn-yellow yellow-button ng-scope']")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//div[@class='user-name']/input")).sendKeys("sonu@gmail.com");
	
	driver.findElement(By.xpath("//div[@class='continue']/input")).click();
	
	Thread.sleep(2000);
	
	
	
	
	
	WebElement title = driver.findElement(By.id("titleDd0"));
	Select sl = new Select(title);
	sl.selectByVisibleText("Mr.");
	
	WebElement first_name=driver.findElement(By.xpath("//div[text()='First Name']/../div[2]/input"));
	first_name.sendKeys("sonu");
	
	WebElement last_name=driver.findElement(By.xpath("//div[text()='Last Name']/../div[2]/input"));
	last_name.sendKeys("kumar");
	
	WebElement dob = driver.findElement(By.xpath("//input[@data-ng-model='booking.dob[$index]']"));
	dob.click();
	
	Select sly=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
	sly.selectByVisibleText("1992");
	
	Select slm=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
	slm.selectByVisibleText("Jul");
	
	driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='3']")).click();
	
	driver.findElement(By.xpath("//div[@class='col-sm-8 type ng-scope']/input[2]")).sendKeys("9632587410");
	
	driver.findElement(By.xpath("//div[text()='Passport Number']/../div/input")).sendKeys("J85632");
	
	driver.findElement(By.xpath("//input[@data-ng-model='booking.passportExpireDate[$index]']")).click();
	
	Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
	sly1.selectByVisibleText("2020");
	
	Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
	slm1.selectByVisibleText("Jul");
	
	driver.findElement(By.xpath("//a[text()='3']")).click();
	
	driver.findElement(By.xpath("//button[text()='CONTINUE' and @class='bttn-yellow']")).click();

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	driver.findElement(By.xpath("//input[@id='cardNumber']")).sendKeys("4000000000000051");
	
	driver.findElement(By.xpath("//input[@id='cardHolderName']")).sendKeys("John Doe");
	
	driver.findElement(By.xpath("//input[@id='cvvNumber']")).sendKeys("111");
	
	Select exp_month = new Select(driver.findElement(By.xpath("//select[@data-ng-model='booking.carExpMonth']")));
	exp_month.selectByVisibleText("12");
	
	Select exp_year= new Select(driver.findElement(By.xpath("//select[@name='expYear']")));
	exp_year.selectByVisibleText("2020");
	
	driver.findElement(By.xpath("//div[@class='box']/input[@name='checkbox']")).click();
	
	driver.findElement(By.xpath("//div[@class='col-md-3 padding-zero']/button[@class='bttn-yellow']")).click();
	
	WebElement status_message= driver.findElement(By.xpath("//div/h3[@class='book-confirm-title ng-binding']"));
			
	Waits.ewait(driver, status_message, 50);
	
	if(status_message.getText().equalsIgnoreCase("Booking Confirmation")) {
		System.out.println("Booking success");
	}
	
	else if(status_message.getText().equalsIgnoreCase("Booking Failed")) {
		System.out.println("Booking failed");
	}
	
		
	}
	
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
	if(result.getStatus()==ITestResult.FAILURE) {
		logger.fail("Test fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		logger.pass("Test pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	}
	report.flush();
}
	
}
