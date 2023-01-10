package com.epr.manage.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuButton;
	@FindBy(id = "inventory_sidebar_link")
	private WebElement allItems;
	@FindBy(id = "logout_sidebar_link")
	private WebElement logOut;
	@FindBy(id = "reset_sidebar_link")
	private WebElement reset;
	@FindBy(id = "about_sidebar_link")
	private WebElement aboutElement;
	@FindBy(id = "shopping_cart_container")
	private WebElement cartButton;
	@FindBy(xpath = "//div[@class='inventory_item_description']//a/div")
	private List<WebElement> listOfProducts;
	@FindBy(id = "checkout")
	private WebElement checkOut;
	@FindBy(id = "finish")
	private WebElement finishButton;

	public WebElement getMenuButton() {
		return menuButton;
	}

	public WebElement getAllItems() {
		return allItems;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getReset() {
		return reset;
	}

	public WebElement getAboutElement() {
		return aboutElement;
	}

	public WebElement getcheckOut() {
		return checkOut;
	}

	public WebElement getCartButton() {
		return cartButton;
	}
	public WebElement getfinishButton() {
		return finishButton;
	}
	public List<WebElement> getlistOfProducts() {
		return listOfProducts;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void log_out() {
		menuButton.click();
		logOut.click();
	}

}
