package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngBasics {

	@BeforeSuite
	public void browserLaunchTest() {
		System.out.println("Launch browser");
	}
	
	@BeforeMethod
	public void getWebpage() {
		System.out.println("Get webpage");
	}
	
	@BeforeTest
	public void enterCred() {
		System.out.println("enter cred");
	}
	
	@Test
	public void login() {
		System.out.println("login test");
	}
	
	@AfterTest
	public void logout() {
		System.out.println("logout");
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("close browser");
	}
	
	@AfterSuite
	public void testDone() {
		System.out.println("test done");
	}
}

