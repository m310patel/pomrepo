package com.amazon.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage homepage;
	
	public LoginPageTest() {
		super();// it will call constructor of TestBase 
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
	lp = new LoginPage();
		
		}
	
	@Test(priority=1)
	public void loginpageTitleTest() {
		String title = lp.validateLoginPageTitle();
		Assert.assertEquals(title, "Amazon Sign In" );
		
	}
	
	@Test(priority=2)
	public void AmazonLogoTest() {
		boolean Amazonlogo = lp.validateamazonlogo();
		Assert.assertTrue(Amazonlogo);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homepage = lp.login(prop.getProperty("UserName"), prop.getProperty("PassWord"));
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
