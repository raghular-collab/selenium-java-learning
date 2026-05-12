package com.sauce.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.base.TestBase;
import com.sauce.pages.CheckoutPage;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import com.sauce.pages.YourCartPage;
import com.sauce.util.TestUtil;

public class YourCartPageTest extends TestBase{
	
	LoginPage loginPage;
	ProductsPage productsPage;
	TestUtil testUtil;
	YourCartPage yourCartPage;
	CheckoutPage checkoutPage;
	
	public YourCartPageTest() {
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
	}
	
	@Test(priority = 1)
	public void verifyButtonsTest() {
		Assert.assertTrue(yourCartPage.verifyPageLabelsBtns());
	}
	@Test(priority = 2)
	public void verifyCheckoutBtnTest() {
		checkoutPage = yourCartPage.verifyCheckoutBtn();
		System.out.println(checkoutPage.verifyTitle());
		Assert.assertEquals(checkoutPage.verifyTitle(),"Checkout: Your Information");
	}
}
