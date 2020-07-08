package testcases.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumchallenges.pages.InfiniteScrollPage;
import theinternet.pages.HomePage;

public class HandlingScroll {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
	}

	@Test
	public void infiniteScroll() {
		HomePage homePage = new HomePage(driver);
		InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScroll();
		
		infiniteScrollPage.scrollToIndex(5);
	}

	@AfterTest
	public void tearDown() {
		Utils.takeScreenshot(driver, "Scroll Test");
		// driver.quit();
	}
}
