package testcases.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mystore.pages.HomePage;

public class AddProductToCart {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void addProductToCart() {
		HomePage homePage = new HomePage(driver);
		homePage.buy("Printed Dress");
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	
}
