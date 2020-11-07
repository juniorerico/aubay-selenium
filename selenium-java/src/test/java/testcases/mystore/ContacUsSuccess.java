package testcases.mystore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mystore.pages.ContactUsPage;
import mystore.pages.HomePage;

public class ContacUsSuccess {
	private WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void contacUsSuccess() {
		HomePage homePage = new HomePage(driver);
		ContactUsPage contactUsPage = homePage.getHeader().clickContactUs();
		
		
		contactUsPage.selectSubject("Webmaster");
		contactUsPage.typeEmail("email@email.com");
		contactUsPage.typeOrderId("123456789");
		contactUsPage.typeMessage("this is a test!");
		contactUsPage.uploadFile("C:\\Users\\Erico\\git\\aubay-selenium\\selenium-java\\src\\test\\resources\\chromedriver.exe");
		contactUsPage.clickSendButton();
		
		String message = "Your message has been successfully sent to our team.";
		
		Assert.assertEquals(contactUsPage.getSuccessMessage(), message);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
