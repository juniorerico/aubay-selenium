package testcases.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import theinternet.pages.DropdownPage;
import theinternet.pages.HomePage;

public class HandleDropdown {
	private WebDriver driver;
	private DropdownPage dropdownPage;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		
		HomePage homePage = new HomePage(driver);
		dropdownPage = homePage.clickDropdown();
	}

	@Test
	public void handleSimpleAlert() {
		dropdownPage.selectOption("Option 2");
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}
