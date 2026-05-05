package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingPropFile {

		public static WebDriver driver; //webdriver is made global so it can be accessed from any in the main body
		
		public static void main(String[] args) throws IOException {

			Properties prop = new Properties(); //Properties object is to handle propertieds file
			
			//FileInputStream is a class used to read data from a file
			FileInputStream ip = new FileInputStream(
					"/Users/raghular/eclipse-workspace/selenium-framework/src/test/java/test/config.properties");
			
			
			prop.load(ip); //This line is used to load data from a file into a Properties object
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			String urll = prop.getProperty("url");
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().deleteAllCookies();
			
			
			driver.get(urll);
			driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(prop.getProperty("username"));
			driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
	}

}
