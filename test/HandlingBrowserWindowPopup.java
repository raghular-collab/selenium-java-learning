package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingBrowserWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.testmuai.com/selenium-playground/window-popup-modal-demo/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[contains(@title,'Follow @Lambdatesting on Twitter')]")).click();
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(driver.getWindowHandles().size() > 1);
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator <String> it = handler.iterator();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(driver.getWindowHandles().size() > 1);
		
		String parentId = it.next();
		System.out.println(parentId);
		
		String childId = it.next();
		System.out.println(childId);
		
		driver.switchTo().window(childId);
		
		Thread.sleep(4000);
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.close();
		
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		

	}

}
