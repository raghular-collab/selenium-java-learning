package com.sauce.util;

	import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class TestUtil {

	    // Time constants
	    public static long IMPLICIT_WAIT = 30;
	    public static long PAGE_LOAD_TIMEOUT = 40;
	    public static long EXPLICIT_WAIT = 10;

	    // Method to apply waits
	    public static void applyImplicitWait(WebDriver driver) {
	        driver.manage().timeouts()
	              .implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	    }

	    public static void applyPageLoadTimeout(WebDriver driver) {
	        driver.manage().timeouts()
	              .pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
	    }
	    
	    public static void waitForElements(WebDriver driver,List<WebElement> elements) {

	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	    	wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	    }
	    
	    public static void waitForElement(WebDriver driver, WebElement elements) {
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	    	wait1.until(ExpectedConditions.visibilityOfAllElements(elements));
	    }
	}


