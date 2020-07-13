package testcases.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import theinternet.pages.DynamicControlsPage;
import theinternet.pages.HomePage;

public class HandlingDisabledElements {
	private WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
	}
	
	@Test
	public void handleDisabled() {
		HomePage homePage = new HomePage(driver);
		DynamicControlsPage dynamicControlsPage = homePage.clickDynamicControls();
		
		dynamicControlsPage.clickEnable();
		dynamicControlsPage.typeInput("It Works!");
	}
	
	@AfterTest
	public void tearDown() {
		
	}
}
