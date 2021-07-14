package com.test.classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pom.classes.HomePage;
import com.pom.classes.LoginPage;

import testBrowsersetup.pojo;


public class loginTest extends pojo  {

	private WebDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;
	static ExtentHtmlReporter reporter;
	static ExtentTest test;
	private Actions action;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
	
		reporter = new ExtentHtmlReporter("test-output//ExtendReport//Extent.html"); 
		ExtentReports extend = new ExtentReports();
		extend.attachReporter (reporter);
		System.out.println("Before Test");
		if (browser.equalsIgnoreCase("Chrome"))
		{
			driver = openChromeBrowser ();
		}
		else if (browser.equalsIgnoreCase("Firefox"))
		{
			driver = openFirefoxBrowser ();
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void beforeclass()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
	}
	@BeforeMethod
	public void beforemethod() throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		loginpage.emailid();
		String name1 = driver.getCurrentUrl();
		System.out.println(name1);
		Thread.sleep(2000);
		
		loginpage.password();
		String name2 = driver.getCurrentUrl();
		System.out.println(name2);	
		Thread.sleep(2000);
		
		loginpage.login();
	}
	
	@Test (priority = 1)
	public void test1() throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		homepage.grocery();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		
		
		
		/*
		 * homepage.electronic(); Thread.sleep(3000); driver.navigate().back();
		 */
		
		String name = driver.getCurrentUrl();
		System.out.println(name);
		
	}
	
	@Test (priority = 2)
	public void test2() throws InterruptedException
	{
		Thread.sleep(2000);
		homepage.mobile();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		
	}
	
	
	@AfterMethod
	public void aftermethod() throws InterruptedException 
	{
		
		action = new Actions(driver);
		WebElement shubham = driver.findElement(By.xpath("(//div[@class=\"exehdJ\"])[1]"));
		action.moveToElement(shubham).perform();
		Thread.sleep(2000);
		
		homepage.logout();
		
		
	}
	
	@AfterClass
	public void afterclass()
	{
		loginpage = null;
		homepage = null;
	}
	
	@AfterTest
	public void aftertest()
	{
		driver.quit();
		driver=null;
		System.gc();
	}
}
