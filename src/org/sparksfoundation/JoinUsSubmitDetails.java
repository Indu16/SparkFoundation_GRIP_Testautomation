package org.sparksfoundation;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JoinUsSubmitDetails {
	
	String WebElementText;
	WebDriver driver;
	String Name = "Indu Nandanan Nair";
	String Email = "indunnair@gmail.com";
	boolean checkContent;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\naray\\Downloads\\chromedriver_win32\\chromedriver.exe");
		final ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	}

	@Test
	public void NavigateToJoinUs() throws Exception{

		driver.get("http://thesparksfoundation.sg");
		Thread.sleep(4000);

		//Navigate to Page: Contact Us
		driver.findElement(By.linkText("Join Us")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Why Join Us")).click();
		Thread.sleep(2000);

		//Assert - Checking the header of the page is "Contact Us"
		WebElementText = driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[2]/h2")).getText();
		System.out.println(WebElementText);
		assertEquals(WebElementText,"Join Us");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/input[1]")).sendKeys(Name);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/input[2]")).sendKeys(Email);
		Select selectBox = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/select")));
		selectBox.selectByIndex(1);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/input[2]")).click();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
