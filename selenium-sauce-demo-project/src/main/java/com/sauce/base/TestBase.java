package com.sauce.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sauce.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
//initialize WebDriver with static variable to use global
	public static WebDriver driver;

//initialize properties with static variable to use global
	public static Properties prop;
	
//TestBase class constructor
	public TestBase() {
		try {
			prop = new Properties(); //Properties object is to handle properties file
			
			//FileInputStream is a class used to read data from a file
			FileInputStream ip = new FileInputStream(
					"/Users/raghular/eclipse-workspace/selenium-sauce-demo/src/main/java/com/sauce/config/config.properties");
			
			
			prop.load(ip); //This line is used to load data from a file into a Properties object
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
//Launching browser	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

	        // ✅ Disable Chrome password popup
	        ChromeOptions options = new ChromeOptions();

	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("credentials_enable_service", false);
	        prefs.put("profile.password_manager_enabled", false);
	        prefs.put("profile.password_manager_leak_detection", false);

	        options.setExperimentalOption("prefs", prefs);
	        options.addArguments("--disable-notifications");
	        options.addArguments("--disable-infobars");

	        driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		TestUtil.applyImplicitWait(driver);
        TestUtil.applyPageLoadTimeout(driver);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	
	
}
