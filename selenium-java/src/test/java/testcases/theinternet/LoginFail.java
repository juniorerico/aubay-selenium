package testcases.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import theinternet.pages.HomePage;
import theinternet.pages.LoginPage;

public class LoginFail {
	private WebDriver driver;
	private LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.clickFormAuthentication();
	}
	
	@Test
	public void usernameInvalid() {
		loginPage.login("usernameinvalid", "SuperSecretPassword!");
		
		Assert.assertTrue(loginPage.getAlertMessage().contains("Your username is invalid!"));
	}
	
	@Test
	public void passwordInvalid() {		
		loginPage.login("tomsmith", "passwordinvalid");
		
		Assert.assertTrue(loginPage.getAlertMessage().contains("Your password is invalid!"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
