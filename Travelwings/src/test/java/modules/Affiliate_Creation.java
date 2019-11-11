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
			
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://test.techtreeit.in/twnc/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 Actions act = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 js.executeScript("arguments[0].value='twadmin'",driver.findElement(By.xpath("//input[@id='userAlias']")));
		 
		 	 
		 driver.findElement(By.xpath("//input[@id='password_password']")).sendKeys("a");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//input[@id='login_id']")).click();

		 driver.findElement(By.xpath("//li[@id='Affiliate']")).click();
		 
		 driver.findElement(By.xpath("//a[@id='add_click']")).click();
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliatePartnerName')]")).sendKeys(Affiliate_Values.partner_name);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliateDescription')]")).sendKeys(Affiliate_Values.Partner_description);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'partnerWebsite')]")).sendKeys(Affiliate_Values.partner_website);
		 
		 driver.findElement(By.xpath("//div[@id='mutti_select']")).click();
		 
		 String product1 = Affiliate_Values.Product;
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[contains(@value,'"+product1+"')]")))).click();
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.formdata.activationPeriodFrom2')]")).click();
		 
		 String from_date = Affiliate_Values.from_date;
		 
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
		 
		 String to_date = Affiliate_Values.to_date;
		 
		 String[] to = to_date.split("-");
		 String to_month = to[1];
		 String to_day = to[0];
		 String to_year = to[2];
		 
		 Select act_month2 = new Select (driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		 act_month2.selectByVisibleText(to_month);
		 
		 Select act_year2 = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		 act_year2.selectByVisibleText(to_year);
		 
		 driver.findElement(By.xpath("//a[contains(@class,'ui-state-default') and text()='"+to_day+"']")).click();
		 
		 String operating_country=Affiliate_Values.country;
		 driver.findElement(By.xpath("//input[contains(@id,'travelwingsCountryName')]")).sendKeys(operating_country);
		 
		 List<WebElement> cont = driver.findElements(By.xpath("//li[@class='ui-menu-item' and text()='"+operating_country+"']"));
		 act.moveToElement(cont.get(0)).click().build().perform();
		 
		 driver.findElement(By.xpath("//label[@for='surcharges']")).click();
		 
		 driver.findElement(By.xpath("//a[@class='isDisabled']")).click();
		 
		 String card = Affiliate_Values.creditcard_type;
		 WebElement cd = driver.findElements(By.xpath("//label[text()='"+card+"']")).get(1);
		 wait.until(ExpectedConditions.elementToBeClickable(cd));
		 cd.click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliateCode')]")).sendKeys(Affiliate_Values.partner_id);
		 
		 WebElement sourceinfo = driver.findElement(By.xpath("//input[contains(@data-ng-model,'sourceInfo')]"));
		 wait.until(ExpectedConditions.elementToBeClickable(sourceinfo));
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'sourceInfo')]")).sendKeys(Affiliate_Values.source_info);

		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'paramThree')]")).sendKeys(Affiliate_Values.parameter_three);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'paramFour')]")).sendKeys(Affiliate_Values.parameter_four);
		 
		 
		 if(product1.equalsIgnoreCase("All")) {
			 
			 String flight = Affiliate_Values.commision_product1;
			 Select sl = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'affiliate.flightComm.selectedProduct')]")));
			 sl.selectByVisibleText(flight);
			 
			 String Partnership_type = Affiliate_Values.Partnership_type1;
			 Select sl1 = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'affiliate.flightComm.partnershipType')]")));
			 sl1.selectByVisibleText(Partnership_type);
			 
			 String amount = Affiliate_Values.amount1;
			 Select sl2 = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'affiliate.flightComm.modeOfCommission')]")));
			 sl2.selectByVisibleText(amount);
			 
			 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.flightComm.valuePerTxn')]")).sendKeys(Affiliate_Values.value_transaction1);
			 
			 Select number_search = new Select(driver.findElement(By.xpath("//select[@id='noOfSearch1']")));
			 String searches = Affiliate_Values.searches1;
			 number_search.selectByVisibleText(searches);
			 
			 String hotel = Affiliate_Values.commision_product2;
			 Select slh = new Select(driver.findElement(By.xpath("//select[@id='commissionProducts2']")));
			 slh.selectByVisibleText(hotel);
			 
			 Select hotel_partnership = new Select(driver.findElement(By.xpath("//select[@id='ddl12']")));
			 hotel_partnership.selectByVisibleText("Transaction");
			 
			 Select hotel_amount = new Select(driver.findElement(By.xpath("//select[@id='ddl22']")));
			 hotel_amount.selectByVisibleText("Amount");
			 
			 driver.findElement(By.xpath("//input[@id='valueTxn2']")).sendKeys(Affiliate_Values.value_transaction2);
			 
		 }
		 
		 else if (product1.equalsIgnoreCase("Hotel")) {
			 Select hotel = new Select(driver.findElement(By.xpath("//select[@id='commissionProducts2']")));
			 hotel.selectByVisibleText("Hotel");
			 
			 Select hotel_partnership = new Select(driver.findElement(By.xpath("//select[@id='ddl12']")));
			 hotel_partnership.selectByVisibleText("Transaction");
			 
			 Select hotel_amount = new Select(driver.findElement(By.xpath("//select[@id='ddl22']")));
			 hotel_amount.selectByVisibleText("Amount");
			 
			 driver.findElement(By.xpath("//input[@id='valueTxn2']")).sendKeys(Affiliate_Values.value_transaction2);
		 }
		 
		 else if (product1.equalsIgnoreCase("Flight")) {
			 
			 String product = Affiliate_Values.commision_product1;
			 Select sl = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'affiliate.flightComm.selectedProduct')]")));
			 sl.selectByVisibleText(product);
			 
			 String Partnership_type = Affiliate_Values.Partnership_type1;
			 Select sl1 = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'affiliate.flightComm.partnershipType')]")));
			 sl1.selectByVisibleText(Partnership_type);
			 
			 String amount = Affiliate_Values.amount1;
			 Select sl2 = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'affiliate.flightComm.modeOfCommission')]")));
			 sl2.selectByVisibleText(amount);
			 
			 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.flightComm.valuePerTxn')]")).sendKeys(Affiliate_Values.value_transaction1);
			 
			 Select number_search = new Select(driver.findElement(By.xpath("//select[@id='noOfSearch1']")));
			 String searches = Affiliate_Values.searches1;
			 number_search.selectByVisibleText(searches);
			 
		 }
		 
		 
		 driver.findElement(By.xpath("//label[contains(@for,'auto-trigger')]")).click();
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.email')]")).sendKeys(Affiliate_Values.email_id);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.cpcValue')]")).sendKeys(Affiliate_Values.cpc_value);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.lookToBookRatio')]")).sendKeys(Affiliate_Values.l2b);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.name')]")).sendKeys(Affiliate_Values.name);
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.email')]")).sendKeys(Affiliate_Values.email);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.phoneNo')]")).sendKeys(Affiliate_Values.phone);
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//div[@class='col-md-4 add_blocktb']/input[contains(@data-ng-model,'contact.country')]")).sendKeys(Affiliate_Values.contact_country);
		 
		 String add_country=Affiliate_Values.contact_country;
		 List<WebElement> india = driver.findElements(By.xpath("//li[@class='ui-menu-item' and text()='India']"));
		 act.moveToElement(india.get(0)).click().build().perform();

		 WebElement city = driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.city')]"));
		 
		 city.sendKeys(Affiliate_Values.city);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.pincode')]")).sendKeys(Affiliate_Values.pincode);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.agreementExpiryDate1')]")).click();
		 
		 String exp_date = Affiliate_Values.agreement_exp;
		 
		 String[] exp = exp_date.split("-");
		 String exp_month = exp[1];
		 String exp_day = exp[0];
		 String exp_year = exp[2];
		 
		 Select exp_month1 = new Select (driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		 exp_month1.selectByVisibleText(exp_month);
		 
		 Select exp_year1 = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		 exp_year1.selectByVisibleText(exp_year);
		 
		 driver.findElement(By.xpath("//a[contains(@class,'ui-state-default') and text()='"+exp_day+"']")).click();
		
		 driver.findElement(By.xpath("//textarea[contains(@data-ng-model,'contact.address')]")).sendKeys(Affiliate_Values.address);
		 
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//input[contains(@id,'file_0')]")).sendKeys("/home/ttuser/Downloads/ARYA.pdf.pdf");
		 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[contains(@id,'file_0')]")).sendKeys("/home/ttuser/Downloads/twbr-f3058.pdf");
		 
		 
		 String payment_mode = Affiliate_Values.payment_mode;
		 Select ls = new Select(driver.findElement(By.xpath("//select[contains(@id,'payment_mode')]")));
		 ls.selectByVisibleText(payment_mode);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.bankAccountNumber')]")).sendKeys(Affiliate_Values.bank_account);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.accountType')]")).sendKeys(Affiliate_Values.account_type);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.bankName')]")).sendKeys(Affiliate_Values.bank_name);
		
		 String currency = Affiliate_Values.currency;
		 Select cr = new Select(driver.findElement(By.id("percentage_amount")));
		 cr.selectByVisibleText(currency);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.settelmentDetails.settelmentPeriod')]")).sendKeys(Affiliate_Values.settlement_period);
		 driver.findElement(By.xpath("//textarea[contains(@data-ng-model,'affiliate.settelmentDetails.remarks')]")).sendKeys(Affiliate_Values.remarks);
		 System.exit(0);
		 
		driver.findElement(By.xpath("//input[contains(@data-ng-click,'affiliate.formSubmit2()')]")).click();
	
	}

}