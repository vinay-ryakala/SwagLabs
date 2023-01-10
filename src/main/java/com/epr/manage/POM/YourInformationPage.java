package com.epr.manage.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage {
	@FindBy(id = "first-name")
	private WebElement firstName;
	@FindBy(id = "last-name")
	private WebElement lastName;
	@FindBy(id = "postal-code")
	private WebElement postalCode;
	@FindBy(id = "continue")
	private WebElement continueButton;
	@FindBy(id = "cancel")
	private WebElement cancelButton;
	
	public  YourInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getPostalCode() {
		return postalCode;
	}
	public WebElement getContinueButton() {
		return continueButton;
	}
	public WebElement getCancelButton() {
		return cancelButton;
	}
	public void fillInformation(String fName, String lName, String zipCode) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(zipCode);
		continueButton.click();
	}
}
