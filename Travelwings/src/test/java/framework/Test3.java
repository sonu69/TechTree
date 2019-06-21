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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test3 {
	
	//private static WebElement element;
	//private static WebDriver driver;
	
	public static void add_pax(WebDriver driver) throws IOException {
		
	List<WebElement> adults = driver.findElements(By.xpath("//h6[contains(text(),'Adult')]"));
	
	List<WebElement> childs = driver.findElements(By.xpath("//h6[contains(text(),'Child')]"));
	
	List<WebElement> infants = driver.findElements(By.xpath("//h6[contains(text(),'Infant')]"));
	
	List<WebElement> titles= driver.findElements(By.xpath("//select[@name='Title']"));
	
	List<WebElement> firstname = driver.findElements(By.xpath("//div[text()='First Name']/../div[2]/input"));
			
	List<WebElement> lastname = driver.findElements(By.xpath("//div[text()='Last Name']/../div[2]/input"));

	List<WebElement> dob = driver.findElements(By.xpath("//input[@data-ng-model='booking.dob[$index]']"));
	
	List<WebElement> phone = driver.findElements(By.xpath("//div[@class='col-sm-8 type ng-scope']/input[2]"));
	
	List<WebElement> passport = driver.findElements(By.xpath("//div[text()='Passport Number']/../div/input"));
	
	List<WebElement> exp_date = driver.findElements(By.xpath("//input[@data-ng-model='booking.passportExpireDate[$index]']"));
	
	List <WebElement> nationality = driver.findElements(By.xpath("//select[@id='countryId']"));
	
		
	int adult_size = adults.size();
	int child_size = childs.size();
	int infant_size = infants.size();
	
	
	for(int i=0;i<adult_size;i++) {
		
		Select sl = new Select(titles.get(i));
		String title = ExcelUtils.getStringValue(17+i, 0);
		sl.selectByVisibleText(title);
		String first_name = ExcelUtils.getStringValue(17+i, 1);
		firstname.get(i).sendKeys(first_name);
		String last_name = ExcelUtils.getStringValue(17+i, 2);
		lastname.get(i).sendKeys(last_name);
		dob.get(i).click();
		Select d_year0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
		String d_year = ExcelUtils.getStringValue(17+i, 4);
		d_year0.selectByVisibleText(d_year);
		
		Select d_month0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		String d_month=ExcelUtils.getStringValue(17+i, 5);

		d_month0.selectByVisibleText(d_month);
		
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='3']")).click();

		String phone_number = ExcelUtils.getStringValue(17+i, 7);
		phone.get(i).sendKeys(phone_number);

		String passport_exp = ExcelUtils.getStringValue(17+i, 8);
		passport.get(i).sendKeys(passport_exp);

		exp_date.get(i).click();

		Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));

		String exp_year = ExcelUtils.getStringValue(17+i, 9);
		sly1.selectByVisibleText(exp_year);

		Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		String exp_month = ExcelUtils.getStringValue(17+i, 10);
		slm1.selectByVisibleText(exp_month);

		driver.findElement(By.xpath("//a[text()='7']")).click();

		Select nation = new Select(nationality.get(i));

		String country = ExcelUtils.getStringValue(17+i, 12);

		nation.selectByVisibleText(country);
		
	}
	
	int m =adult_size;
	for(int j=0;j<child_size;j++) {
		
		Select sl = new Select(titles.get(j+m));
		String title = ExcelUtils.getStringValue(26+j, 0);
		sl.selectByVisibleText(title);
		
		String first_name = ExcelUtils.getStringValue(26+j, 1);
		firstname.get(j+m).sendKeys(first_name);
		
		String last_name = ExcelUtils.getStringValue(26+j, 2);
		lastname.get(j+m).sendKeys(last_name);
		
		dob.get(j+m).click();
		
		Select d_year0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
		String d_year = ExcelUtils.getStringValue(26+j, 4);
		d_year0.selectByVisibleText(d_year);
		

		Select d_month0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		String d_month=ExcelUtils.getStringValue(26+j, 5);

		d_month0.selectByVisibleText(d_month);
		
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='3']")).click();

		String phone_number = ExcelUtils.getStringValue(26+j, 7);
		phone.get(j+m).sendKeys(phone_number);

		String passport_exp = ExcelUtils.getStringValue(26+j, 8);
		passport.get(j+m).sendKeys(passport_exp);

		exp_date.get(j+m).click();

		Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));

		String exp_year = ExcelUtils.getStringValue(26+j, 9);
		sly1.selectByVisibleText(exp_year);

		Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		String exp_month = ExcelUtils.getStringValue(26+j, 10);
		slm1.selectByVisibleText(exp_month);

		driver.findElement(By.xpath("//a[text()='7']")).click();

		Select nation = new Select(nationality.get(j+m));

		String country = ExcelUtils.getStringValue(26+j, 12);

		nation.selectByVisibleText(country);
		
	}
	
	
	int l =adult_size+child_size;
	for(int k=0;k<infant_size;k++) {
		
		Select sl = new Select(titles.get(k+l));
		String title = ExcelUtils.getStringValue(38+k, 0);
		sl.selectByVisibleText(title);
		
		String first_name = ExcelUtils.getStringValue(38+k, 1);
		firstname.get(k+l).sendKeys(first_name);
		String last_name = ExcelUtils.getStringValue(38+k, 2);
		lastname.get(k+l).sendKeys(last_name);
		
		dob.get(k+l).click();
		Select d_year0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
		String d_year = ExcelUtils.getStringValue(38+k, 4);
		d_year0.selectByVisibleText(d_year);
		
		Select d_month0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		String d_month=ExcelUtils.getStringValue(38+k, 5);

		d_month0.selectByVisibleText(d_month);
		
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='3']")).click();

		String phone_number = ExcelUtils.getStringValue(38+k, 7);
		phone.get(k+l).sendKeys(phone_number);

		String passport_exp = ExcelUtils.getStringValue(38+k, 8);
		passport.get(k+l).sendKeys(passport_exp);

		exp_date.get(k+l).click();

		Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));

		String exp_year = ExcelUtils.getStringValue(38+k, 9);
		sly1.selectByVisibleText(exp_year);

		Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));

		String exp_month = ExcelUtils.getStringValue(38+k, 10);
		slm1.selectByVisibleText(exp_month);

		driver.findElement(By.xpath("//a[text()='7']")).click();

		Select nation = new Select(nationality.get(k+l));

		String country = ExcelUtils.getStringValue(38+k, 12);

		nation.selectByVisibleText(country);
		
	}
}

	
	public static void main(String[] args) throws IOException {
	

	}

}
