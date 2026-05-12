package com.sauce.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.base.TestBase;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	ProductsPage productsPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPage();
		Assert.assertEquals(title,"Swag Labs");
	}
	
	@Test(priority = 2)
	public void swagLabsLogoTest() {
		boolean logo = loginPage.verifyLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority = 3)
	public void verifyUsernamePassword() {
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
