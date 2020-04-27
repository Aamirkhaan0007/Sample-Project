package com.selenium.MCX.infra;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebBasePages {

	protected WebDriver driver;

	public WebBasePages(WebDriver driver) {
		this.driver = driver;

	}

	public void WaitForLocatorToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public void WaitForElementToBeClickable(By Webelement) {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(Webelement));

	}

	public void WaitForElementToBeClicableFluently(By locator, int PolligTime) {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(PolligTime)).ignoring(NoSuchElementException.class);
		fluent.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public void WaitForLocatorToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void WaitForLocatorToBePresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public void WaitForElementToBePresentFluently(By locator, int PolligTime) {
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(PolligTime)).ignoring(NoSuchElementException.class);
		fluent.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
}
