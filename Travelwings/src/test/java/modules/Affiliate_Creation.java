package modules;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Affiliate_Creation {

	public static void main(String[] args) throws InterruptedException {
		 
		String path=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/chromedriver");
		//System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		 
		 //System.setProperty("webdriver.chrome.driver", "/home/ttuser/Downloads/chromedriver_linux64 (3)/chromedriver");
		 
		 
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		 driver.get("https://test.techtreeit.in/twnc/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 Actions act = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 
		 
		 js.executeScript("arguments[0].value='twadmin'",driver.findElement(By.xpath("//input[@id='userAlias']")));
		 //driver.findElement(By.xpath("//input[@id='userAlias']")).sendKeys("twadmin");
		 
		 //js.executeScript("arguments[0].value='twadmin'",driver.findElement(By.xpath("//input[@id='password_password']")));
		 driver.findElement(By.xpath("//input[@id='password_password']")).sendKeys("twadmin");
		 
		 Thread.sleep(2000);
		 
		 
		 driver.findElement(By.xpath("//input[@id='login_id']")).click();

		 driver.findElement(By.xpath("//li[@id='Affiliate']")).click();
		 
		 driver.findElement(By.xpath("//a[@id='add_click']")).click();
		 
		 
		 		 
		 //js.executeScript("arguments[0].value='AFT114'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliateCode')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliateCode')]")).sendKeys("AFT001");
		 
		 //js.executeScript("arguments[0].value='Bihar'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliatePartnerName')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliatePartnerName')]")).sendKeys("Bihar");
		 
		 //js.executeScript("arguments[0].value='this is just for the testing purpose'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliateDescription')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliateDescription')]")).sendKeys("this is just for the testing purpose");
		 
		 //js.executeScript("arguments[0].value='https://www.google.com'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'partnerWebsite')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'partnerWebsite')]")).sendKeys("https://www.google.com");
		 
		 driver.findElement(By.xpath("//div[@id='mutti_select']")).click();
		 
		 String product1 = "All";
		 
		 WebElement el = driver.findElements(By.xpath("//label[text()='"+product1+"']")).get(0);
		 wait.until(ExpectedConditions.elementToBeClickable(el));
		 el.click();
		 
		 
		 
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.formdata.activationPeriodFrom2')]")).click();
		 
		 String from_date = "25-Aug-2019";
		 
		 String[] fd = from_date.split("-");
		 String from_month = fd[1];
		 String from_day = fd[0];
		 String from_year = fd[2];
		 
		 Select act_month = new Select (driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		 act_month.selectByVisibleText(from_month);
		 
		 Select act_year = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		 act_year.selectByVisibleText(from_year);
		 
		 driver.findElement(By.xpath("//a[contains(@class,'ui-state-default') and text()='"+from_day+"']")).click();
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.formdata.activationPeriodEnd2')]")).click();
		 
		 String to_date = "30-Oct-2019";
		 
		 String[] to = to_date.split("-");
		 String to_month = to[1];
		 String to_day = to[0];
		 String to_year = to[2];
		 
		 Select act_month2 = new Select (driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		 act_month2.selectByVisibleText(to_month);
		 
		 Select act_year2 = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		 act_year2.selectByVisibleText(to_year);
		 
		 driver.findElement(By.xpath("//a[contains(@class,'ui-state-default') and text()='"+to_day+"']")).click();
		 
		 
		 driver.findElement(By.xpath("//input[contains(@id,'travelwingsCountryName')]")).sendKeys("ind");
		 
		 List<WebElement> cont = driver.findElements(By.xpath("//li[@class='ui-menu-item' and text()='India']"));
		 act.moveToElement(cont.get(0)).click().build().perform();
		 
		 driver.findElement(By.xpath("//label[@for='surcharges']")).click();
		 
		 
		 driver.findElement(By.xpath("//a[@class='isDisabled']")).click();
		 
		 String card = "All";
		 WebElement cd = driver.findElements(By.xpath("//label[text()='"+card+"']")).get(1);
		 wait.until(ExpectedConditions.elementToBeClickable(cd));
		 cd.click();
		 Thread.sleep(2000);
		 
		 WebElement sourceinfo = driver.findElement(By.xpath("//input[contains(@data-ng-model,'sourceInfo')]"));
		 wait.until(ExpectedConditions.elementToBeClickable(sourceinfo));
		 js.executeScript("arguments[0].value='Bihar1'",sourceinfo);
		 Thread.sleep(2000);
		 
		 
		 //js.executeScript("arguments[0].value='Bihar2'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'paramThree')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'paramThree')]")).sendKeys("Bihar2");
		 
		 //js.executeScript("arguments[0].value='Bihar3'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'paramFour')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'paramFour')]")).sendKeys("Bihar3");
		 
		 String product = "Hotel";
		 Select sl = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'comm.selectedProduct')]")));
		 sl.selectByVisibleText(product);
		 
		 String Partnership_type = "CPC";
		 Select sl1 = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'comm.partnershipType')]")));
		 sl1.selectByVisibleText(Partnership_type);
		 
		 String amount = "Amount";
		 Select sl2 = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'comm.modeOfCommission')]")));
		 sl2.selectByVisibleText(amount);
		 
		 
		 //js.executeScript("arguments[0].value='50'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'comm.valuePerTxn')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'comm.valuePerTxn')]")).sendKeys("50");
		 
		 //js.executeScript("arguments[0].value='5000'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'comm.noOfSearch')]")));
		 //driver.findElement(By.xpath("//input[contains(@data-ng-model,'comm.noOfSearch')]")).sendKeys("5000");
		 
		 Select number_search = new Select(driver.findElement(By.xpath("//select[@id='noOfSearch0']")));
		 String searches = "1000 - 5000";
		 number_search.selectByVisibleText(searches);
		 
		 
		 driver.findElement(By.xpath("//label[contains(@for,'auto-trigger')]")).click();
		 
		 //js.executeScript("arguments[0].value='sonu111@yopmail.com'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.email')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.email')]")).sendKeys("sonu111@yopmail.com");
		 
		 
		 js.executeScript("arguments[0].value='1000'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.cpcValue')]")));
		 //driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.cpcValue')]")).sendKeys("1000");
		 
		 
		 //js.executeScript("arguments[0].value='2.50'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.lookToBookRatio')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.lookToBookRatio')]")).sendKeys("2.50");
		 
		 
		 //js.executeScript("arguments[0].value='Lata dev'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.name')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.name')]")).sendKeys("Lata dev");
		 
		 //js.executeScript("arguments[0].value='sonu111@yopmail.com'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.email')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.email')]")).sendKeys("sonu321@yopmail.com");
		 
		 //js.executeScript("arguments[0].value='9874563210'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.phoneNo')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.phoneNo')]")).sendKeys("9874563210");
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//div[@class='col-md-4 add_blocktb']/input[contains(@data-ng-model,'contact.country')]")).sendKeys("india");
		 
		 List<WebElement> india = driver.findElements(By.xpath("//li[@class='ui-menu-item' and text()='India']"));
		 act.moveToElement(india.get(0)).click().build().perform();

		 WebElement city = driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.city')]"));
		 //js.executeScript("arguments[0].value='Ashoke'",city);
		 
		 city.sendKeys("Ashoke");
		 
		 //js.executeScript("arguments[0].value='896523'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.pincode')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.pincode')]")).sendKeys("896523");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.agreementExpiryDate1')]")).click();
		 
		 
		 String exp_date = "30-Dec-2019";
		 
		 String[] exp = exp_date.split("-");
		 String exp_month = exp[1];
		 String exp_day = exp[0];
		 String exp_year = exp[2];
		 
		 Select exp_month1 = new Select (driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		 exp_month1.selectByVisibleText(exp_month);
		 
		 Select exp_year1 = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		 exp_year1.selectByVisibleText(exp_year);
		 
		 driver.findElement(By.xpath("//a[contains(@class,'ui-state-default') and text()='"+exp_day+"']")).click();
		
		 
		 //js.executeScript("arguments[0].value='B163, new'",driver.findElement(By.xpath("//textarea[contains(@data-ng-model,'contact.address')]")));
		 driver.findElement(By.xpath("//textarea[contains(@data-ng-model,'contact.address')]")).sendKeys("B163,new");
		 
		 //js.executeScript("arguments[0].value='/home/ttuser/Downloads/Shivam_shekhar_QA.pdf'",driver.findElement(By.xpath("//input[contains(@id,'file_0')]")));
		 //driver.findElement(By.xpath("//input[contains(@id,'file_0')]")).sendKeys("/home/ttuser/Downloads/Shivam_shekhar_QA.pdf");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//input[contains(@id,'file_0')]")).sendKeys("/home/ttuser/Pictures/4th June/1.png");
		 
		 
		 String payment_mode = "Cash";
		 Select ls = new Select(driver.findElement(By.xpath("//select[contains(@id,'payment_mode')]")));
		 ls.selectByVisibleText(payment_mode);
		 
		 //js.executeScript("arguments[0].value='1234567896'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.bankAccountNumber')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.bankAccountNumber')]")).sendKeys("1234567896");
		 
		 
		 //js.executeScript("arguments[0].value='savings'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.accountType')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.accountType')]")).sendKeys("savings");
		 
		 //js.executeScript("arguments[0].value='HDFC'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.bankName')]")));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.bankName')]")).sendKeys("HDFC");
		
		 String currency = "USD";
		 Select cr = new Select(driver.findElement(By.id("percentage_amount")));
		 cr.selectByVisibleText(currency);
		 
		 js.executeScript("arguments[0].value='1111'",driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.settelmentPeriod')]")));
		 
//		 String period = "Half Yearly";
//		 Select pr = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'affiliate.settelmentDetails.settelmentPeriod')]")));
//		 pr.selectByVisibleText(period);
		 
		 //js.executeScript("arguments[0].value='Success'",driver.findElement(By.xpath("//textarea[contains(@data-ng-model,'affiliate.settelmentDetails.remarks')]")));
		 driver.findElement(By.xpath("//textarea[contains(@data-ng-model,'affiliate.settelmentDetails.remarks')]")).sendKeys("Success");
		  
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-click,'affiliate.formSubmit2()')]")).click();
	
	}

}