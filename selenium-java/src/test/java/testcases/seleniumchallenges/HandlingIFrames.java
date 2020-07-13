package testcases.seleniumchallenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumchallenges.pages.IFramePage;

public class HandlingIFrames {
	private WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://juniorerico.github.io/aubay-selenium/iframe-practice.html");
	}
	
	@Test
	public void challengeFive() {
		IFramePage iframePage = new IFramePage(driver);
		iframePage.switchToIframe();
		iframePage.clickButtonYellowGroupOne();
		
		Assert.assertEquals(iframePage.getResultOne(), "Muito bem!");
	}
	
	@AfterTest
	public void tearDown() {
		SeleniumUtils.takeScreenshot(driver, "Handling Iframes");
	}
}
