package testcases.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import theinternet.pages.DynamicLoadingPage;
import theinternet.pages.DynamicLoadingPageExampleOne;
import theinternet.pages.HomePage;

public class HandlingWaits {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
	}

	@Test
	public void waitForElement() {
		HomePage homePage = new HomePage(driver);
		DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
		DynamicLoadingPageExampleOne dynamicLoadingPageExampleOne = dynamicLoadingPage.clickExampleOne();
		
		dynamicLoadingPageExampleOne.clickStartButton();
		
		Assert.assertEquals(dynamicLoadingPageExampleOne.getResult(), "Hello World!");
	}

	@AfterTest
	public void tearDown() {
		Utils.takeScreenshot(driver, "Teste");
	}
}
