package testBrowsersetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class pojo {

	public static WebDriver openChromeBrowser () {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shubham\\Desktop\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		return driver;
		
		}
		
		public static WebDriver openFirefoxBrowser () {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shubham\\Desktop\\geckodriver.exe");
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("disable-notifications");
			WebDriver driver = new FirefoxDriver (options);
			return driver;
			
			}
}