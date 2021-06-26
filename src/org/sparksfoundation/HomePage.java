package org.sparksfoundation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePage {
	WebDriver driver;
	String actualTitle;
	String expectedTitle = "The Sparks Foundation | Home";
	String WebElementText;
	boolean logoPresent;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\naray\\Downloads\\chromedriver_win32\\chromedriver.exe");
		final ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	}


	@Test(priority =1)
	public void CheckTitle() throws Exception{
		
		driver.get("http://thesparksfoundation.sg");
		Thread.sleep(4000);
		actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		assertEquals(expectedTitle,actualTitle);
		Thread.sleep(2000);
	}
	
	@Test(priority =2)
	public void VerifyLogoPresent() throws Exception{
		logoPresent = driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[1]/h1/a/img")).isDisplayed();
		assertTrue(logoPresent);
	}
	
	@Test(priority =3)
	public void TestNavigation() throws Exception{
		WebElementText = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/h2")).getText();
		assertEquals(WebElementText,"The Sparks Foundation");
		
		//Navigating to LINK page
		driver.findElement(By.linkText("LINKS")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Software & App")).click();
		Thread.sleep(2000);
				
		//Navigating back to home page
		driver.navigate().back();
		
		//Checking whether home page is displayed
		
		WebElementText = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/h2")).getText();
		System.out.println(WebElementText);
		assertEquals(WebElementText,"The Sparks Foundation");
		
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}


}
