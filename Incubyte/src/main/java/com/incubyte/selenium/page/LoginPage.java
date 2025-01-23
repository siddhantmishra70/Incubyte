package com.incubyte.selenium.page;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.incubyte.selenium.utility.CommonFunctions;
import com.incubyte.selenium.utility.MyTestResults;

public class LoginPage extends CommonFunctions {
	boolean temp = false;
	static MyTestResults results = new MyTestResults();

	@FindBy(linkText = "Create an Account")
	WebElement link_CreateAccount;
	
	@FindBy(xpath = "//a[normalize-space(text()) = 'Sign In']")
	WebElement link_Signin;
	
	@FindBy(name = "login[username]")
	WebElement txt_username;
	
	@FindBy(name = "login[password]")
	WebElement txt_password;
	
	@FindBy(xpath = "//button[@class='action login primary']")
	WebElement btn_login;
	
	@FindBy(xpath = "//div[@role='alert']//div/div")
	WebElement lbl_invalidloginmessage;
	
	
	
	
	
	
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validate_LoginPage()
	{
		Assert.assertEquals(getDriver().getTitle(), "Customer Login");
	}
	
	public void enter_email(String email)
	{
		CommonFunctions.waitVisibilityofElement(txt_username);
		txt_username.sendKeys(email);
	}
	
	public void enter_password(String password)
	{
		CommonFunctions.waitVisibilityofElement(txt_password);
		txt_password.sendKeys(password);
	}
	
	public void click_on_sigin()
	{
		CommonFunctions.waitVisibilityofElement(btn_login);
		btn_login.click();
		
	}
	
	public void validateHomePage()
	{
		Assert.assertEquals(getDriver().getTitle(), "Home Page");
	}
	
	public void validate_invalidlogin_message()
	{
		Assert.assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.", lbl_invalidloginmessage.getText());
	}
}

