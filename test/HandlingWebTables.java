package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWebTables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		
		//*[@id="product"]/tbody/tr[2]/td[2]
		//*[@id="product"]/tbody/tr[3]/td[2]
		//*[@id="product"]/tbody/tr[1]
		//*[@id="product"]/tbody/tr[2]/td[1]
		//*[@id="product"]/tbody/tr[1]
		//*[@id="product"]/tbody/tr[2]/td[1]
		//*[@id="product"]/tbody/tr[2]/td[2]
		
		List<WebElement> table_rows = driver.findElements(By.xpath("//table[@name=\"courses\"]/tbody/tr"));
		int row_count = table_rows.size();
		System.out.println("row :" + row_count);
		
		List<WebElement> table_columns = driver.findElements(By.xpath("//table[@name=\"courses\"]/tbody/tr[2]/td"));
		int column_count = table_columns.size();
		System.out.println("column :" + column_count);
		
		String row_xpath1 = "//*[@id=\"product\"]/tbody/tr[";
		String row_xpath2 = "]";
		
		String column_xpath1 = "//*[@id=\"product\"]/tbody/tr[2]/td[";
		String column_xpath2 = "]";
		
		for (int i=1;i<=column_count;i++) {
			String column_data = driver.findElement(By.xpath(column_xpath1 + i + column_xpath2)).getText();
			if(i == 2) {
				System.out.println(column_data);
				System.out.println("--------------------");	
			}
			
		}
		
		for(int j =1; j<=row_count;j++) {
			String row_data = driver.findElement(By.xpath(row_xpath1 + j + row_xpath2)).getText();
			if(j == 7) {
				System.out.println(row_data);	
				System.out.println("--------------------");
			}
			
			
		}
		

		

	}

}
