package integrationTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ERP.mange.genric.BaseClass;
import com.ERP.mange.genric.GenrateTestData;
import com.epr.manage.POM.HomePage;
import com.epr.manage.POM.YourInformationPage;

public class AddToCartVerifyCheckOutTest extends BaseClass {
	@Test
	public void addToCartAndVerifyCheckOut() {
		GenrateTestData gtd = new GenrateTestData();
		HomePage hPage = new HomePage(driver);
		driver.findElement(By.xpath(
				"//div[.='Sauce Labs Bolt T-Shirt']//ancestor::div[@class='inventory_item_description']//descendant::button"))
				.click();
		hPage.getCartButton().click();
		hPage.getcheckOut().click();
		YourInformationPage yIPage = new YourInformationPage(driver);
		yIPage.fillInformation(gtd.firstName(), gtd.lastName(), gtd.zipCode());
		hPage.getfinishButton().click();
		String acctualString = driver.findElement(By.xpath("//span[@class='title']")).getText();
		String expectedString = "CHECKOUT: COMPLETE!";
		Assert.assertEquals(acctualString, expectedString);

	}
	@Test
	public void getListOfProducts() {
		HomePage hPage = new HomePage(driver);
		for (WebElement productName : hPage.getlistOfProducts()){
		System.out.println(	productName.getText());
		Assert.assertEquals(hPage.getlistOfProducts().size(), 6);
		}
	}
} 
