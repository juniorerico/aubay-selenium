package testcases.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mystore.pages.HomePage;
import mystore.pages.ProductPage;

public class AddMoreProductToCart {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void addProductSizeM() {
		HomePage homePage = new HomePage(driver);
		ProductPage productPage = homePage.clickProduct("Blouse");
		
		Assert.assertEquals(productPage.getName(), "Blouse");
		
		productPage.typeQuantity("2");
		productPage.clickButtonUp();
		
		Assert.assertEquals(productPage.getQuantity(), "3");
		
		productPage.clickButtonDown();
		
		Assert.assertEquals(productPage.getQuantity(), "2");
		
		productPage.selectSize("M");
		productPage.addToCart();
		
		productPage.getAddToCartModal().continueShopping();
		
		int productCount = productPage.getHeader().getShoppingCart().getProductCount();
		
		Assert.assertEquals(productCount, 2);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
