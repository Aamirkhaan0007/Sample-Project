package com.selenium.MCX.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.selenium.MCX.infra.WebBasePages;

public class MCXHomePage extends WebBasePages {

	public MCXHomePage(WebDriver driver) {
		super(driver);
	}

	private static final By MARKET_DATA = By.linkText("MARKET DATA");
	private static final By MARKET_WATCH = By.linkText("Market Watch");
	private static final By GOLD_LINK = By
			.xpath("(//td[@class='symbol chnge-perc right5' and a[text()='GOLD']])[1]//following::td[14]");
	private static final By DATE = By.xpath("//span[@id='asondate']");
	private static final By TIME = By.xpath("//strong[@id='asontime']");
	private static final By REFRESHBUTTON = By.xpath("//a[@id='btnRefresh']");

	public void clickOnMarketData() {
		WaitForLocatorToBeVisible(MARKET_DATA);
		WebElement market = driver.findElement(MARKET_DATA);
		market.click();
	}

	public void clickOnMarketWatch() {
		WaitForLocatorToBeVisible(MARKET_WATCH);
		WebElement marketWatch = driver.findElement(MARKET_WATCH);
		marketWatch.click();
	}

	public String getGoldLacsValue() throws InterruptedException {
		WaitForLocatorToBePresent(GOLD_LINK);
		WebElement getdate = driver.findElement(DATE);
		String date = getdate.getText();
		WebElement gettime = driver.findElement(TIME);
		String time = gettime.getText();
		WebElement gold = driver.findElement(GOLD_LINK);
		String gold_lacs_value = gold.getText();
		System.out.println("gold value on " + date + " " + time + " is " + gold_lacs_value);
		Thread.sleep(120000);
		return gold_lacs_value;
	}

	public void clickOnRefreshButton() throws InterruptedException {
		WebElement refresh = driver.findElement(REFRESHBUTTON);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", refresh);
		Thread.sleep(5000);
	}

	public String getGoldLacsValue2() {
		WaitForLocatorToBePresent(GOLD_LINK);
		WebElement getdate = driver.findElement(DATE);
		String date2 = getdate.getText();
		WebElement gettime = driver.findElement(TIME);
		String time2 = gettime.getText();
		WebElement gold = driver.findElement(GOLD_LINK);
		String gold_lacs_value2 = gold.getText();
		System.out.println("gold value on " + date2 + " " + time2 + " is " + gold_lacs_value2);
		return gold_lacs_value2;
	}

	public void CompareGoldPrice(String gold1, String gold2) {
		if (gold1.equalsIgnoreCase(gold2)) {
			System.out.println("gold prices are equal after 2 mins");
		} else {
			System.out.println("Gold prices changed after 2 mins");
		}
	}
}