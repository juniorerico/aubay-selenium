package testcases.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import theinternet.pages.AlertsPage;
import theinternet.pages.HomePage;

public class HandleAlert {
	private WebDriver driver;
	private AlertsPage alertsPage;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		
		HomePage homePage = new HomePage(driver);
		alertsPage = homePage.clickJavascriptAlerts();
	}

	@Test
	public void handleSimpleAlert() {
		alertsPage.clickButtonJsAlert();
		
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(alertsPage.getResult(), "You successfuly clicked an alert");
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
