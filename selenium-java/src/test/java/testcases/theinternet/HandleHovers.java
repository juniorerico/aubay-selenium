package testcases.theinternet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import io.github.bonigarcia.wdm.WebDriverManager;
import theinternet.pages.DropdownPage;
import theinternet.pages.HomePage;
import theinternet.pages.HoversPage;

public class HandleHovers {
	private WebDriver driver;
	private HoversPage hoversPage;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
	}

	@Test
	public void hoverFigures() {
		
	}
	
	@Test
	public void hoveraFigures() {
		
	}
	
	@AfterTest
	public void tearDown(TestResult result) {
		System.out.println(result.getName());
		//driver.quit();
	}
}
