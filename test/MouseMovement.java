package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Feature')]"))).build().perform();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	}
	

}
