package com.sauce.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.base.TestBase;
import com.sauce.util.TestUtil;

public class ProductsPage extends TestBase{
	
	@FindBy(className = "title")
	WebElement productsLabel;
	
	//burger menu
	@FindBy(id="react-burger-menu-btn")
	WebElement burgerMenu;
	
	@FindBy(className="bm-item-list")
	List<WebElement> menuList;
	
	@FindBy(className="bm-cross-button")
	WebElement closeBurgerMenu;
	
	//Product Title Links
	@FindBy(xpath="//a[contains(@id,'title')]")
	List<WebElement> productNames;
	
	@FindBy(xpath="//div[contain(text(),'inventory-item-desc')]")
	WebElement clickProduct;
	
	@FindBy(className="inventory_details_desc")
	WebElement prodDesc;
	
	@FindBy(id="back-to-products")
	WebElement goBack;

	@FindBy(id="item_0_title_link")
	WebElement bikeLightLink;
	
	@FindBy(id="item_1_title_link")
	WebElement boldtshirtLink;
	
	@FindBy(id="item_2_title_link")
	WebElement onesieLink;
	
	@FindBy(id="item_3_title_link")
	WebElement redTshirt;
	
	@FindBy(id="item_4_title_link")
	WebElement backpackLink;
	
	@FindBy(id="item_5_title_link")
	WebElement fleeceJacketLink;
	

	//add to cart btn
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	List<WebElement> countButton;
	
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	WebElement clickButton;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement addToCartBackpackBtn;
	
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement addToCartTshirtBtn;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement addToCartBikeLightBtn;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	WebElement addToCartFleeceJacket;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement addToCartBoldTshirt;
	
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	WebElement addToCartOnesie;
	
	//remove btn
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement removeBackpack;
	
	@FindBy(id="remove-test.allthethings()-t-shirt-(red)")
	WebElement removetshirt;
	
	@FindBy(id = "remove-sauce-labs-bike-light")
	WebElement removeBikeLight;
	
	@FindBy(id = "remove-sauce-labs-bolt-t-shirt")
	WebElement removeBoldTshirt;
	
	@FindBy(id = "remove-sauce-labs-fleece-jacket")
	WebElement removeFleeceJacket;
	
	@FindBy(id = "remove-sauce-labs-onesie")
	WebElement removeOnesie;
	
	//cart link
	@FindBy(className = "shopping_cart_link")
	WebElement cartLink;
	
	
	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyProductPageTitle() {
		return productsLabel.getText();
	}
	//click add to cart
	public void clickBackPack() {
		addToCartBackpackBtn.click();		
	}
	public void clickBikeLight() {
		addToCartBikeLightBtn.click();
	}
	public void clickOnesie() {
		addToCartOnesie.click();
	}
	public void clickFleeceJacket() {
		addToCartFleeceJacket.click();
	}
	public void clickBoldTshirt() {
		addToCartBoldTshirt.click();
	}
	public void clickRedTshirt() {
		addToCartTshirtBtn.click();
	}

	public boolean isButtonNowRemove() {
	    return addToCartBackpackBtn.getText().equals("Remove");
	}
	public boolean verifyRemoveBackpack() {
		return removeBackpack.isDisplayed();
	}
	
	public int countAddToCartBtn() {
		return countButton.size();	
	}
	public void clickAddToCart() {
		clickButton.click();
	}
	public int countProduct() {
		return productNames.size();
	}
	public String getProductNames() {
		String names = "";
		for (int i = 0; i < productNames.size(); i++) {
			System.out.println(productNames.get(i).getText());
	    }
		return names;
	}
	public void getDesc() {
		WebElement[] products = {bikeLightLink,boldtshirtLink,onesieLink,redTshirt,backpackLink,fleeceJacketLink};
		int j = 0;
		for (j=0;j<products.length;j++){
			String prodtitle = products[j].getText();
			System.out.println(prodtitle);
			
			products[j].click();
			System.out.println("clicked");
			
			String desc = prodDesc.getText();
			System.out.println(desc);
			goBack.click();
			System.out.print("Went Back");
		}
		
	}
	public boolean validatingBurgerMenu() {
		
		burgerMenu.click();
		
		TestUtil.waitForElements(driver, menuList);
		
		int menuCount = menuList.size();
		
		System.out.println(menuCount);
		int mc = 0;
		for (mc=0;mc<menuCount;mc++) {
			String bmList = menuList.get(mc).getText();
			System.out.println(bmList);
			
		}
		System.out.println(mc);
		
		closeBurgerMenu.click();
		
		return mc == 1;
	}


	public YourCartPage validateCart() {
		cartLink.click();
		return new YourCartPage();		
	}

}
