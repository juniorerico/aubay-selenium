package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumchallenges.pages.InfiniteScrollPage;

/**
 * Page Object da Home Page do site The Internet 
 * 
 * @author Erico
 *
 */
public class HomePage {
	private WebDriver driver;
	
	// Locator do Link "Form Authentication"
	private By linkFormAuthentication = By.linkText("Form Authentication");
	private By linkJavascriptAlerts = By.linkText("JavaScript Alerts");
	private By linkDropDown = By.linkText("Dropdown");
	private By linkHovers = By.linkText("Hovers");
	private By linkInfitineScroll = By.linkText("Infinite Scroll");
	private By linkDynamicLoading = By.linkText("Dynamic Loading");
	private By linkDynamicControls = By.linkText("Dynamic Controls");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Método que realiza a ação de clicar no link Form Authentication
	// Este método retorna a próxima página (Login Page)
	public LoginPage clickFormAuthentication() {
		driver.findElement(linkFormAuthentication).click();
		return new LoginPage(driver);
	}
	
	public AlertsPage clickJavascriptAlerts() {
		driver.findElement(linkJavascriptAlerts).click();
		return new AlertsPage(driver);
	}
	
	public DropdownPage clickDropdown() {
		driver.findElement(linkDropDown).click();
		return new DropdownPage(driver);
	}
	
	public HoversPage clickHovers() {
		driver.findElement(linkHovers).click();
		return new HoversPage(driver);
	}
	
	public InfiniteScrollPage clickInfiniteScroll() {
		driver.findElement(linkInfitineScroll).click();
		return new InfiniteScrollPage(driver);
	}
	
	public DynamicLoadingPage clickDynamicLoading() {
		driver.findElement(linkDynamicLoading).click();
		return new DynamicLoadingPage(driver);
	}
	
	public DynamicControlsPage clickDynamicControls() {
		driver.findElement(linkDynamicControls).click();
		return new DynamicControlsPage(driver);
	}
}
