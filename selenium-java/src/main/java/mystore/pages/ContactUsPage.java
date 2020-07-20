package mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import commons.SeleniumUtils;

public class ContactUsPage extends BasePage {
	private By dropDownSubject = By.id("id_contact");
	private By inputEmail = By.id("email");
	private By inputOrderId = By.id("id_order");
	private By inputFile = By.id("fileUpload");
	private By textAreaMessage = By.id("message");
	private By buttonSend = By.id("submitMessage");

	private By successMessage = By.cssSelector(".alert-success");
	private By errorMessage = By.cssSelector(".alert-danger");

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	public void selectSubject(String value) {
		SeleniumUtils.selectDropDown(getDriver().findElement(dropDownSubject), value);
	}

	public void typeEmail(String value) {
		SeleniumUtils.sendKeys(getDriver().findElement(inputEmail), value);
	}

	public void typeOrderId(String value) {
		SeleniumUtils.sendKeys(getDriver().findElement(inputOrderId), value);
	}

	public void uploadFile(String path) {
		getDriver().findElement(inputFile).sendKeys(path);
	}

	public void typeMessage(String value) {
		SeleniumUtils.sendKeys(getDriver().findElement(textAreaMessage), value);
	}

	public void clickSendButton() {
		getDriver().findElement(buttonSend).click();
	}

	public String getSuccessMessage() {
		return SeleniumUtils.waitForElementToBeVisible(getDriver(), successMessage).getText();
	}

	public String getErrorMessage() {
		return SeleniumUtils.waitForElementToBeVisible(getDriver(), errorMessage).getText();
	}
}
