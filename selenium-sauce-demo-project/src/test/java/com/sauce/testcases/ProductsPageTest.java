package com.sauce.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.base.TestBase;
import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import com.sauce.pages.YourCartPage;

public class ProductsPageTest extends TestBase{
	
	LoginPage loginPage;
	ProductsPage productsPage;
	YourCartPage yourCartPage;
	
	public ProductsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();	
		productsPage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyProductPageTitleTest() {
		String productPageTitle = productsPage.verifyProductPageTitle();
		Assert.assertEquals(productPageTitle,"Products","Title not found");
	}
	
	@Test(priority = 2)
	public void verifyClickOnCartTest() {
		productsPage.clickBackPack();
		Assert.assertTrue(productsPage.verifyRemoveBackpack());
		}
	@Test(priority = 3)
	public void verifyAddCartCountTest() {
		int count = productsPage.countAddToCartBtn();
		System.out.println(count);
		int i = 0;
		for (i=0;i <count;i++) {
			productsPage.clickAddToCart();
		}
		
	}
	
	@Test(priority = 4)
	public void clickAllProductsTest() {
		int prodCount = productsPage.countProduct();
		System.out.println(prodCount);
	}
	
	@Test(priority = 5)
	public void getProductNamesTest() {
		productsPage.getProductNames();
	}
	
	@Test(priority = 6)
	public void getDescTest() {
		productsPage.getDesc();
	}
	
	@Test(priority = 7)
	public void verifyBurgerMenuTest() {
		Assert.assertTrue(productsPage.validatingBurgerMenu());	
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
