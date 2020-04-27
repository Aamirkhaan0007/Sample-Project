package com.selenium.MCX.test;

import java.io.IOException;
import org.testng.annotations.Test;

import com.selenium.MCX.infra.WebBaseTest;
import com.selenium.MCX.pages.MCXHomePage;

public class MCX_Test extends WebBaseTest {

	@Test
	public void test() throws IOException, InterruptedException {
		MCXHomePage MCX = new MCXHomePage(driver);
		MCX.clickOnMarketData();
		MCX.clickOnMarketWatch();
		String GoldValue1 = MCX.getGoldLacsValue();
		MCX.clickOnRefreshButton();
		String GoldValue2 = MCX.getGoldLacsValue2();
		MCX.CompareGoldPrice(GoldValue1, GoldValue2);
	}
}
