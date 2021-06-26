package org.sparksfoundation;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckContentOnContactUsPage {

	String WebElementText;
	WebDriver driver;
	String ExpectedAddress = "21 HENG MUI KENG TERRACE, SINGAPORE, 119613";
	String ExpectedPhone = "+65-8402-8590, info@thesparksfoundation.sg";
	boolean checkContent;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\naray\\Downloads\\chromedriver_win32\\chromedriver.exe");
		final ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	}

	@Test
	public void NavigateToContactUs() throws Exception{

		driver.get("http://thesparksfoundation.sg");
		Thread.sleep(4000);

		//Navigate to Page: Contact Us
		driver.findElement(By.linkText("Contact Us")).click();
		Thread.sleep(2000);

		//Assert - Checking the header of the page is "Contact Us"
		WebElementText = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/h2")).getText();
		System.out.println(WebElementText);
		assertEquals(WebElementText,"Contact Us");

		// Check address content

		WebElementText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/p")).getText();
		System.out.println(WebElementText);
		//assertEquals(WebElementText,ExpectedAddress);
		boolean checkContent  = WebElementText.contains(ExpectedAddress);
		//assertTrue(checkContent);

		// Check address content

		WebElementText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/p[2]")).getText();
		System.out.println(WebElementText);
		assertEquals(WebElementText,ExpectedPhone);
		//boolean checkContent  = WebElementText.contains(ExpectedPhone);
		assertTrue(checkContent);

	}

	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
	}


}
