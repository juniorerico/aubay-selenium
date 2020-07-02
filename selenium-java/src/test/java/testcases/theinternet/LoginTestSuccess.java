package testcases.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import theinternet.pages.HomePage;
import theinternet.pages.LoginPage;

public class LoginTestSuccess {
	private WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
	}
	
	@Test
	public void loginSuccess() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickFormAuthentication();
		
		loginPage.login("tomsmith", "SuperSecretPassword!");
		
		// OBS: A verificaçaõ se o login foi realizado corretamete será feita aqui
		// Explicarei na próxima aula
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
