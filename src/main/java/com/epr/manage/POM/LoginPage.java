package com.epr.manage.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ERP.mange.genric.WebDriverUtil;

public class LoginPage {
	WebDriver driver;
	@FindBy(id ="user-name")
	private WebElement userName;
	@FindBy(id ="password")
	private WebElement pwd;
	@FindBy(id = "login-button")
	private WebElement loginButton;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	WebDriverUtil wDriverUtil= new WebDriverUtil(driver);
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPwd() {
		return pwd;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	public void login(String uName, String passWord) {
		userName.sendKeys(uName);
		pwd.sendKeys(passWord);
		loginButton.click();
	}
	
}	
