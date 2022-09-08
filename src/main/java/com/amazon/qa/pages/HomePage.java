package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(linkText = "Books")
	WebElement clickonbooks;
	
	@FindBy(linkText = "Prime Student")
	WebElement clickonprimestudents;
	
	@FindBy(xpath = "//*[@aria-label='eBook Deals']")
	WebElement ebooksdeal;
	
	@FindBy(xpath = "//*[@id='nav-link-accountList-nav-line-1']")
	WebElement HelloMansi;


public HomePage(){
	
	PageFactory.initElements(driver, this);
}


public String verifyHomePageTitle() {
	return driver.getTitle();
}

public boolean verifyHelloMansi() {
	return HelloMansi.isDisplayed();
}

public BooksPage ClickOnBooksLink() {
	clickonbooks.click();
	return new BooksPage();
	
	
}



}