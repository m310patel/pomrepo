package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	/* here i have to define pagefactory  - or OR (object repository)*/
	
	
	@FindBy (name ="email")
	WebElement UserName;
	
	@FindBy (name ="password")
	WebElement PassWord;
	
	@FindBy (id ="continue")
	WebElement continuebtn;
	
	@FindBy (id ="signInSubmit")
	WebElement signinbtn;
	
	@FindBy (xpath ="//a[@class='a-link-nav-icon']")
	WebElement amazonlogo;
	
	
	// with this i initialize my pageobjectss, This means current class
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions 
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateamazonlogo() {
		return amazonlogo.isDisplayed();
	}
	
	public  HomePage login(String Uname, String ps) {
	
		UserName.sendKeys(Uname);
		continuebtn.click();
		PassWord.sendKeys(ps);
		signinbtn.click();
		
		return new HomePage();
		
		
		
	}
	
	
	
	

}
