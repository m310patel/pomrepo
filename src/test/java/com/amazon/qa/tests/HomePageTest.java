package com.amazon.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.BooksPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage lp;
	HomePage homepage;
	BooksPage  bookspage;
	
	public HomePageTest() {
		super();
	}
	
	/*Testcases should be independant or seprated - 
	 * after every test launch the browser & lohin
	 * & after each test close browser
	 * It helps to avoid app crash, browser crash or deleting cookies n all unexpected stuff*/
	
	@BeforeMethod
	public void setUp() {
		initialization();
	lp = new LoginPage();
	bookspage = new BooksPage ();
	homepage = lp.login(prop.getProperty("UserName"), prop.getProperty("PassWord"));
		
		}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "Amazon.ca : amazon sign in");
	}
	
	@Test(priority=2)
	public void verifyHelloMansiTest() {
		Assert.assertTrue(homepage.verifyHelloMansi());
	}
	
	@Test(priority=3)
	public void verifyBooksLink() {
		bookspage = homepage.ClickOnBooksLink();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
