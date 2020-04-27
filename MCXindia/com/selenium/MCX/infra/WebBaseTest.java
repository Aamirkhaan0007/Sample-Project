package com.selenium.MCX.infra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class WebBaseTest {

	protected WebDriver driver;

	@BeforeSuite
	@Parameters({ "browser" })

	public void startup(String browser) throws Exception {

		String url = new PropertiesFileReader().GetUrl();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\BrowsersDrivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "F:\\Selenium\\BrowsersDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}
