package testcases.seleniumchallenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumchallenges.pages.HomePage;

public class ChallengeFour {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://juniorerico.github.io/aubay-selenium/selectors-practice.html");
	}
	
	@Test
	public void BuyProductByName() {
		HomePage homePage = new HomePage(driver);
		homePage.buy("Produto 3");
		
		Assert.assertEquals(homePage.getResult(), "Muito bem!");
	}
	
	@AfterTest
	public void tearDown() {
		
	}
}
