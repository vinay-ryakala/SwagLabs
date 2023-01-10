package com.ERP.mange.genric;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.epr.manage.POM.HomePage;
import com.epr.manage.POM.LoginPage;

public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	public WebDriverUtil wDriverUtil;
	
	@BeforeClass(groups = {"smoke","regression"})
	public void openBrowser()  {
		driver = new ChromeDriver();
		sdriver=driver;
		wDriverUtil= new WebDriverUtil(driver);
		wDriverUtil.maximizeWindow();
		
	}

	@BeforeMethod(groups = {"smoke","regression"})
	public void login() throws IOException, ParseException {
		ReadDataFromJSON readDataFromJSON= new ReadDataFromJSON();
		String url = readDataFromJSON.readDataFromJson("url");		
		String adminUserName = readDataFromJSON.readDataFromJson("username");
		String adminPwd = readDataFromJSON.readDataFromJson("password");
		driver.get(url);
		wDriverUtil.waitDriver();
		LoginPage loginPage= new LoginPage(driver);
		loginPage.login(adminUserName, adminPwd);

	}
	@AfterMethod(groups = {"smoke","regression"})
	public void logout() {
		HomePage hPage = new HomePage(driver);
		hPage.log_out();
	}

	@AfterClass(groups = {"smoke","regression"})
	public void closeBrowser() {
		driver.close();
	}
	
}
