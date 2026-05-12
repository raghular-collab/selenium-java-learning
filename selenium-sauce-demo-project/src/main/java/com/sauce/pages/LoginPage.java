package com.sauce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory - Object Repository:
	@FindBy(name="user-name")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	@FindBy(className = "login_logo")
	WebElement logo;
	
	//Initializing Page Objects:
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		}
	//Actions:	
	public String validateLoginPage() {
		return driver.getTitle();
	}
	public boolean verifyLogo() {
		return logo.isDisplayed();
	}
	public ProductsPage login(String username, String pwd) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new ProductsPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
