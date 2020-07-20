package mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.SeleniumUtils;

public class ProductPage extends BasePage {
	private By name = By.xpath("//h1[@itemprop='name']");
	private By inputQuantity = By.id("quantity_wanted");
	private By buttonQuantityDown = By.cssSelector(".product_quantity_down");
	private By buttonQuantityUp = By.cssSelector(".product_quantity_up");
	private By dropdownSize = By.id("group_1");
	private By buttonAddToCart = By.id("add_to_cart");
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public String getName() {
		return SeleniumUtils.waitForElementToBeVisible(getDriver(), name).getText();
	}
	
	public void typeQuantity(String value) {
		WebElement element = getDriver().findElement(inputQuantity);
		
		element.clear();
		element.sendKeys(value);
	}
	
	public String getQuantity() {
		return getDriver().findElement(inputQuantity).getAttribute("value");
	}
	
	public void clickButtonDown() {
		getDriver().findElement(buttonQuantityDown).click();
	}
	
	public void clickButtonUp() {
		getDriver().findElement(buttonQuantityUp).click();
	}
	
	public void selectSize(String value) {
		SeleniumUtils.selectDropDown(getDriver().findElement(dropdownSize), value);
	}
	
	public void addToCart() {
		getDriver().findElement(buttonAddToCart).click();
	}
}
