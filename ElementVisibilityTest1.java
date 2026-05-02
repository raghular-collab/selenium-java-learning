package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementVisibilityTest1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.testautomationcentral.com/demo/buttons.html");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		//isEnabled method - to verify if the element is enabled on the webpage
		driver.findElement(By.xpath("//button[text()='Disabled Button']")).click();
		boolean b4 = driver.findElement(By.xpath("//button[text()='Disabled']")).isEnabled();
		System.out.println(b4);

	}

}
