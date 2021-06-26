package org.sparksfoundation;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AboutVisionMissionAndValues {

	WebDriver driver;
	String actualTitle;
	String expectedTitle = "The Sparks Foundation | Home";
	String WebElementText;


	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\naray\\Downloads\\chromedriver_win32\\chromedriver.exe");
		final ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	}


	@Test
	public void NavigateToAboutUs() throws Exception{
		
		driver.get("http://thesparksfoundation.sg");
		Thread.sleep(4000);
		actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		assertEquals(expectedTitle,actualTitle);
		driver.findElement(By.linkText("About Us")).click();
		Thread.sleep(2000);

		//Navigate to Page: Vision, Mission and Values
		driver.findElement(By.linkText("Vision, Mission and Values")).click();
		Thread.sleep(2000);

		//Assert - Checking the header of the page is "Vision, Mission And Values"
		WebElementText = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/h2")).getText();
		System.out.println(WebElementText);
		assertEquals(WebElementText,"Vision, Mission And Values");

		//Navigate to Page: Guiding Principles
		driver.findElement(By.linkText("Guiding Principles")).click();
		Thread.sleep(2000);

		//Assert - Checking the header of the page is "Guiding Principles"
		WebElementText = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/h2")).getText();
		System.out.println(WebElementText);
		assertEquals(WebElementText,"Guiding Principles");
		
		
		//Navigate to Page: Executive Team
		driver.findElement(By.linkText("Executive Team")).click();
		Thread.sleep(5000);

		//Assert - Checking the header of the page is "Executive Team"
		WebElementText = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/h2")).getText();
		System.out.println(WebElementText);
		assertEquals(WebElementText,"Executive Team");
		
		
		//Navigate to Page: Corporate Partners
		driver.findElement(By.linkText("Corporate Partners")).click();
		Thread.sleep(1000);

		//Assert - Checking the header of the page is "Corporate Partners"
		WebElementText = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/h2")).getText();
		System.out.println(WebElementText);
		assertEquals(WebElementText,"Corporate Partners");




	}
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
	}


}
