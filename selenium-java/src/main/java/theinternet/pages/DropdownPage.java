package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
	private WebDriver driver;

	private By dropdown = By.id("dropdown");

	public DropdownPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectOption(String value) {
		WebElement dropdownElement = driver.findElement(dropdown);

		Select select = new Select(dropdownElement);
		select.selectByVisibleText(value);
	}
}
