package com.sauce.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.base.TestBase;

public class YourCartPage extends TestBase{
	

	//Labels
	@FindBy(className="title")
	WebElement cartPageLabel;
	
	@FindBy(className="cart_quantity_label")
	WebElement qtyLabel;
	
	@FindBy(className="cart_desc_label")
	WebElement descLabel;
	
	//Btns
	@FindBy(id="continue-shopping")
	WebElement continueShoppingbtn;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement removeBtn;
	
	//Cart Details
	@FindBy(className="cart_item")
	List<WebElement> cartItem;
	
	@FindBy(className="cart_quantity")
	List<WebElement> cartQuantity;
	
	@FindBy(className="inventory_item_price")
	List<WebElement> itemPrice;
	
	public YourCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return cartPageLabel.getText();
	}

	public boolean verifyPageLabelsBtns() {
		boolean status = cartPageLabel.isDisplayed()
		&& qtyLabel.isDisplayed()
		&& descLabel.isDisplayed();
		if(status) {
			System.out.println("Buttons are displayed");
		}else {
			System.out.println("Buttons not displayed");
		}
		return status;
	}
	public boolean verifyPageBtns() {
		return continueShoppingbtn.isDisplayed()
		&& checkoutBtn.isDisplayed()	
		&& removeBtn.isDisplayed();
	}
	public void verifyRemoveBtn() {
		removeBtn.click();
	}
	public void verifyContinueBtn() {
		continueShoppingbtn.click();
	}
	public CheckoutPage verifyCheckoutBtn() {
		checkoutBtn.click();
		return new CheckoutPage();
	}
	public void cartItemDetails() {

	    for (WebElement item : cartItem) {
	        System.out.println("Cart Item: "+ item.getText());
	    }
	    for (WebElement quantity: cartQuantity) {
	    	System.out.println("Item Quantity: "+ quantity.getText());
	    }
	    for (WebElement price : itemPrice) {
	    	System.out.println("Item Price: "+price.getText());
	    	
	    }
	}
	

}
