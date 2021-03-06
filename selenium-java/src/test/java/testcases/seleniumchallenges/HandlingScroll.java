package testcases.seleniumchallenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumchallenges.pages.ScrollPage;

public class HandlingScroll {
	private WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://juniorerico.github.io/aubay-selenium/practice-scroll.html");
	}
	
	@Test
	public void challengeSix() {
		ScrollPage scrollPage = new ScrollPage(driver);
		scrollPage.clickButton();
	}
	
	@AfterTest
	public void tearDown() {
		SeleniumUtils.takeScreenshot(driver, "Handling Scroll");
	}
}
