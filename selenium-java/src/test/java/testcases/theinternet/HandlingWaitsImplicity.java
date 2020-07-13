package testcases.theinternet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import theinternet.pages.DynamicLoadingPage;
import theinternet.pages.DynamicLoadingPageExampleOne;
import theinternet.pages.DynamicLoadingPageExampleTwo;
import theinternet.pages.HomePage;

public class HandlingWaitsImplicity {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		
		// Implicity Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void waitForElement() {
		HomePage homePage = new HomePage(driver);
		DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoading();
		DynamicLoadingPageExampleTwo dynamicLoadingPageExampleTwo = dynamicLoadingPage.clickExampleTwo();
		
		dynamicLoadingPageExampleTwo.clickStartButton();
		
		Assert.assertEquals(dynamicLoadingPageExampleTwo.getResult(), "Hello World!");
	}

	@AfterTest
	public void tearDown() {
		SeleniumUtils.takeScreenshot(driver, "Teste");
	}
}
