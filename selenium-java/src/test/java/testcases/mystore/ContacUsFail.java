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

public class ContacUsFail {
	private WebDriver driver;
	private ContactUsPage contactUsPage;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		HomePage homePage = new HomePage(driver);
		contactUsPage = homePage.getHeader().clickContactUs();
	}
	
	@Test(priority = 1)
	public void noSubjectError() {		
		contactUsPage.typeEmail("email@email.com");
		contactUsPage.typeOrderId("123456789");
		contactUsPage.typeMessage("this is a test!");
		contactUsPage.uploadFile("C:\\Users\\Erico\\git\\aubay-selenium\\selenium-java\\src\\test\\resources\\chromedriver.exe");
		contactUsPage.clickSendButton();
				
		Assert.assertTrue(contactUsPage.getErrorMessage().contains("There is 1 error"));
		Assert.assertTrue(contactUsPage.getErrorMessage().contains("Please select a subject from the list provided."));
	}
	
	@Test(priority = 2)
	public void noEmailError() {
		contactUsPage.selectSubject("Webmaster");
		contactUsPage.typeEmail("");
		contactUsPage.clickSendButton();
		
		Assert.assertTrue(contactUsPage.getErrorMessage().contains("There is 1 error"));
		Assert.assertTrue(contactUsPage.getErrorMessage().contains("Invalid email address."));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
