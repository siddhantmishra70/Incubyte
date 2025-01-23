package com.incubyte.selenium.page;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.incubyte.selenium.utility.CommonFunctions;
import com.incubyte.selenium.utility.MyTestResults;

public class HomePage extends CommonFunctions {
	boolean temp = false;
	static MyTestResults results = new MyTestResults();

	@FindBy(linkText = "Create an Account")
	WebElement link_CreateAccount;
	
	@FindBy(xpath = "//a[normalize-space(text()) = 'Sign In']")
	WebElement link_Signin;
	
	
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validate_homepage()
	{
		CommonFunctions.waitVisibilityofElement(link_CreateAccount);
		Assert.assertEquals(link_CreateAccount.isDisplayed(), true);
	}
	
	public void click_CreateAccount()
	{
		CommonFunctions.waitVisibilityofElement(link_CreateAccount);
		link_CreateAccount.click(); 
	}
	
	public void click_Signin()
	{
		CommonFunctions.waitVisibilityofElement(link_Signin);
		link_Signin.click(); 
	}
	
}

