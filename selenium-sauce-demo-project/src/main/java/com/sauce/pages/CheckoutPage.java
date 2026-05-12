package com.sauce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.base.TestBase;

public class CheckoutPage extends TestBase{

	@FindBy(className="title")
	WebElement title;
	
	@FindBy(id="cancel")
	WebElement cancelBtn;
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String  verifyTitle() {
		return title.getText();
	}
	public String passInfo(String firstname, String lastname, String zipcode) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		postalCode.sendKeys(zipcode);
		
		return firstname + " " + lastname + " " + zipcode;	
		}
	public void clickContinue() {
		continueBtn.click();
	}
	public void clickCancel() {
		cancelBtn.click();
	}
	public CheckoutOverviewPage validationContinue() {
		continueBtn.click();
		return new CheckoutOverviewPage();
	}


}


