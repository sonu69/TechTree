package modules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Affiliate_Creation {

	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://test.techtreeit.in/twnc/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.findElement(By.xpath("//input[@id='userAlias']")).sendKeys("twadmin");
		 
		 driver.findElement(By.xpath("//input[@id='password_password']")).sendKeys("twadmin");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='login_id']")).click();

		 driver.findElement(By.xpath("//li[@id='Affiliate']")).click();
		 
		 driver.findElement(By.xpath("//a[@id='add_click']")).click();
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.formdata.activationPeriodFrom2')]")).click();
		 
		 String from_date = "30-July-2019";
		 
		 String[] fd = from_date.split("-");
		 String from_month = fd[1];
		 String from_day = fd[0];
		 
		 WebElement month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		 String month1 = month.getText();
		 
		 
		 for(int i=0;i<12;i++)
		 if(month1.equalsIgnoreCase(from_month)){
			 driver.findElement(By.xpath("//a[contains(@class,'ui-state-default') and text()='"+from_day+"']")).click();
			 break;
			 }
		 
		 else 
		 {driver.findElement(By.xpath("//span[text()='Next']")).click();
		 
		 }
		 
		 System.exit(0);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliateCode')]")).sendKeys("sonu");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliatePartnerName')]")).sendKeys("sonu");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliateDescription')]")).sendKeys("sonu");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'partnerWebsite')]")).sendKeys("sonu");
		 
		 driver.findElement(By.xpath("//div[@id='mutti_select']")).click();
		 
		 String product1 = "All";
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 WebElement el = driver.findElements(By.xpath("//input[text()='"+product1+"']")).get(0);
		 wait.until(ExpectedConditions.elementToBeClickable(el)).click();
		 
		 //Activation Period from
//		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.formdata.activationPeriodFrom2')]")).click();
//		 
//		 String from_date = "30-July-2019";
//		 
//		 String[] fd = from_date.split("-");
//		 String from_month = fd[1];
//		 String from_day = fd[0];
//		 
//		 WebElement month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
//		 String month1 = month.getText();
//		 
//		 if(month1.equalsIgnoreCase(from_month)){
//			 driver.findElement(By.xpath("//a[contains(@class,'ui-state-default') and text()='"+from_day+"']")).click();}
//		 
//		 else 
//		 {driver.findElement(By.xpath("//span[text()='Next']")).click();
//		 
//		 }
		 
		 //Activation Period to
		 
		 driver.findElement(By.xpath("//input[contains(@id,'travelwingsCountryName')]")).sendKeys("india");
		 
		 Actions act = new Actions(driver);
		 act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//li[text()='India']"))).build().perform();
		 
		 driver.findElement(By.xpath("//input[@value='VISA']")).click();
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'sourceInfo')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'paramThree')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'paramFour')]")).sendKeys("");
		 
		 String product = "";
		 Select sl = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'comm.selectedProduct')]")));
		 sl.selectByVisibleText(product);
		 
		 String Partnership_type = "";
		 Select sl1 = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'comm.partnershipType')]")));
		 sl1.selectByVisibleText(Partnership_type);
		 
		 String amount = "";
		 Select sl2 = new Select(driver.findElement(By.xpath("//select[contains(@data-ng-model,'comm.modeOfCommission')]")));
		 sl2.selectByVisibleText(amount);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'comm.valuePerTxn')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'comm.noOfSearch')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//label[contains(@for,'auto-trigger')]")).click();
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.email')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.cpcValue')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'affiliate.commission.lookToBookRatio')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.name')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.email')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.phoneNo')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.country')]")).sendKeys("india");
		 act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//li[@class='ui-menu-item' and text()='India']"))).build().perform();
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.city')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.pincode')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.agreementExpiryDate1')]")).click();
		 
		 driver.findElement(By.xpath("//textarea[contains(@data-ng-model,'contact.address')]")).sendKeys("");
		 
		 //driver.findElement(By.xpath("")).sendKeys("");
		 
		 //driver.findElement(By.xpath("")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@id,'file_0')]")).sendKeys("");
		 
		 
		 String payment_mode = "";
		 Select ls = new Select(driver.findElement(By.xpath("//select[contains(@id,'payment_mode')]")));
		 ls.selectByVisibleText(payment_mode);
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.email')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.phoneNo')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.country')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.city')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.pincode')]")).sendKeys("");
		 
		 driver.findElement(By.xpath("//input[contains(@data-ng-model,'contact.agreementExpiryDate1')]")).click();
	}

}
