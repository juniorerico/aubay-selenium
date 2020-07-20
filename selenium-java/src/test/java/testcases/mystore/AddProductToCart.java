package testcases.mystore;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mystore.pages.HomePage;

public class AddProductToCart {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		Reporter.log("##### SETUP #####");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void addProductToCart() {
		HomePage homePage = new HomePage(driver);
		
		double price1 = homePage.addProductToCart("Blouse");
		homePage.getAddToCartModal().continueShopping();
		
		System.out.println("Preço do primeiro produto: " + price1);
		
		double price2 = homePage.addProductToCart("Faded Short Sleeve T-shirts");
		homePage.getAddToCartModal().continueShopping();
		
		System.out.println("Preço do segundo produto: " + price2);
		
		int productCount = homePage.getHeader().getShoppingCart().getProductCount();
		Assert.assertEquals(productCount, 2);
		
		double shippingCost = homePage.getHeader().getShoppingCart().getShippingPrice();
		double totalPrice = homePage.getHeader().getShoppingCart().getTotalPrice();
		
		double expectedTotal = price1 + price2 + shippingCost;
		
		System.out.println("Valor do frete: " + shippingCost);
		System.out.println("Valor total esperado: " + expectedTotal);
		System.out.println("Valor total no carriho: " + totalPrice);
		
		BigDecimal total = new BigDecimal(expectedTotal).setScale(2, BigDecimal.ROUND_DOWN);
		
		Assert.assertEquals(totalPrice, total.doubleValue());
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
