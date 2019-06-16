package framework;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import actions.FlightSelect_Page;
import actions.Search_Inputs;
import pageObjects.Itinerary_Page;
import pageObjects.SearchFlight_Page;
import pageObjects.YourEmailId_Page;

public class Test2 {
	
	static WebDriver driver;
	static WebElement element;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get("https://newuat.travelwings.com/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				String origin = "Delhi";
				String destination = "DXB";
				
				Search_Inputs.add_origin(driver, origin);
				Search_Inputs.add_destination(driver, destination);

				//Search_Inputs.journeydate(driver, "august", "25");
				String journey_month="July";
				String journey_date="18";
				Search_Inputs.journeydate(driver, journey_month, journey_date);
				
				//Search_Inputs.returndate(driver, "september", "29");
				String return_month="July";
				String return_date="24";
				Search_Inputs.returndate(driver, return_month, return_date);
				
				int adult = 2;
				int child = 2;
				int infants = 2;
				
				Search_Inputs.pax_list(driver, adult, child, infants);
				
				Search_Inputs.fligh_tname(driver, "Etihad");
				
				Thread.sleep(10000);
				
				SearchFlight_Page.search_flight(driver).click();
				
				Thread.sleep(10000);
				FlightSelect_Page.select_flight(driver);
				//IndiGo Airlines
				//Emirates
				//Etihad
				//Oman Air
				Itinerary_Page.continue_itinerary(driver).click();	
				
				YourEmailId_Page.account_login(driver, "sonu.kumar@techtreeit.com", "sonu3791");
				
				List<WebElement> titles= driver.findElements(By.xpath("//select[@name='Title']"));
				
				List<WebElement> firstname = driver.findElements(By.xpath("//div[text()='First Name']/../div[2]/input"));
						
				List<WebElement> lastname = driver.findElements(By.xpath("//div[text()='Last Name']/../div[2]/input"));

				List<WebElement> dob = driver.findElements(By.xpath("//input[@data-ng-model='booking.dob[$index]']"));
				
				List<WebElement> phone = driver.findElements(By.xpath("//div[@class='col-sm-8 type ng-scope']/input[2]"));
				
				List<WebElement> passport = driver.findElements(By.xpath("//div[text()='Passport Number']/../div/input"));
				
				List<WebElement> exp_date = driver.findElements(By.xpath("//input[@data-ng-model='booking.passportExpireDate[$index]']"));
				
				List <WebElement> nationality = driver.findElements(By.xpath("//select[@id='countryId']"));
				
				String title1 = ExcelUtils.getStringValue(17, 0);
				System.out.println(title1);
				
				int size = titles.size();
				
				for(int i=0;i<size;i++) {
					
					Select sl = new Select(titles.get(i));
					String title = ExcelUtils.getStringValue(17+i, 0);
					sl.selectByVisibleText(title);
					String first_name = ExcelUtils.getStringValue(17+i, 1);
					firstname.get(i).sendKeys(first_name);
					String last_name = ExcelUtils.getStringValue(17+i, 2);
					lastname.get(i).sendKeys(last_name);
					
					dob.get(i).click();
					Select d_year0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
					String d_year = ExcelUtils.getStringValue(17+i, 3);
					d_year0.selectByVisibleText(d_year);
					
	Select d_month0=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
	String d_month=ExcelUtils.getStringValue(17+i, 4);
	d_month0.selectByVisibleText(d_month);
					
	
	driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='3']")).click();
	
	phone.get(i).sendKeys("9905040207");
	
	
	passport.get(i).sendKeys("J8965230");
	
	
	
	exp_date.get(i).click();
	Select sly1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")));
	
	
	sly1.selectByVisibleText("2020");
	
	Select slm1=new Select(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")));
	slm1.selectByVisibleText("Jul");
	
	driver.findElement(By.xpath("//a[text()='7']")).click();
	
	
	
	
	
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	}

}
