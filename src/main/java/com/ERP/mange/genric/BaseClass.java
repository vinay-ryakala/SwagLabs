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
	//@Parameters("browser")
	@BeforeClass()
	public void openBrowser()  {
//		if (browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else {
//			driver = new FirefoxDriver();
//		}
		driver = new ChromeDriver();
		sdriver=driver;
		wDriverUtil= new WebDriverUtil(driver);
		wDriverUtil.maximizeWindow();
		
	}

	@BeforeMethod()
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
	@AfterMethod()
	public void logout() {
		HomePage hPage = new HomePage(driver);
		hPage.log_out();
	}

	@AfterClass()
	public void closeBrowser() {
		driver.close();
	}
	
}
