package DataDriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.util.TestUtil;

public class DataTest {
 
	WebDriver driver;
	TestUtil testUtil;
	String sheetName = "contacts";
	
	@BeforeMethod
	public void setUp(){
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		testUtil = new TestUtil();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws Exception{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void DataDrivenTest(String Username, String Password){
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
			
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
