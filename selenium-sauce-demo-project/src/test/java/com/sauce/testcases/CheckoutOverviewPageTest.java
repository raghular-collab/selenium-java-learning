package com.sauce.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.base.TestBase;
import com.sauce.pages.CheckoutOverviewPage;
import com.sauce.pages.CheckoutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import com.sauce.pages.YourCartPage;
import com.sauce.util.TestUtil;

public class CheckoutOverviewPageTest extends TestBase{
	LoginPage loginPage;
	ProductsPage productsPage;
	YourCartPage yourCartPage;
	CheckoutPage checkoutPage;
	TestUtil testUtil;
	CheckoutOverviewPage checkoutOverviewPage;
	
	public CheckoutOverviewPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();	
		productsPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		productsPage.clickBackPack();
		yourCartPage = productsPage.validateCart();
		checkoutPage = yourCartPage.verifyCheckoutBtn();
		checkoutPage.passInfo(prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("zipcode"));
		checkoutPage.validationContinue();
	}
	@Test(priority =1)
	public void verifyfetchTotalPrice() {
		checkoutOverviewPage.fetchTotalPrice();
	}
}
