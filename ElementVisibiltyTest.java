package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementVisibiltyTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//isDisplayed method - to verify if element is displayed on webpage 
		boolean b1 = driver.findElement(By.xpath("//button[text()='Login']")).isDisplayed();
		System.out.println(b1);
		
		boolean b2 = driver.findElement(By.xpath("//button[text()='Login']")).isDisplayed();
		System.out.println(b2);
		
		//isSelected method - to verify if the element is selected or not, only applicable for checkbox, radiobutton, dropdown
		Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
		select.selectByVisibleText("Option1");
		

		WebElement selectedOption = select.getFirstSelectedOption(); //gives the first selected option
		System.out.println(selectedOption.getText());
		
		boolean b3 = selectedOption.isSelected();
		System.out.println(b3);
		

	}

}
