package FreeTestAutomation.FreeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeCRMTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		    WebDriverManager.chromedriver().setup();
         
	        driver = new ChromeDriver();
	               
	        driver.manage().window().maximize();
	              
	        driver.get("https://www.google.com");
			
	}
	
	
	@Test
	public void SydneyUniversityTest(){
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Sydney");

		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();

		driver.findElement(By.xpath("//h3[normalize-space()='The University of Sydney']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1000)");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//a[@aria-label='Learn more']//span[@class='cmp-button__text'][normalize-space()='Learn more']")).click();

	}
        
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
