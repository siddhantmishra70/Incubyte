package com.incubyte.selenium.page;
import java.util.List;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.incubyte.selenium.utility.CommonFunctions;
import com.incubyte.selenium.utility.MyTestResults;

public class CustomerRegistrationPage extends CommonFunctions {
	boolean temp = false;
	static MyTestResults results = new MyTestResults();
	public String password;
	@FindBy(name  = "firstname")
	WebElement txt_firstname;

	@FindBy(name  = "lastname")
	WebElement txt_lastname;
	
	@FindBy(name  = "email")
	WebElement txt_email;
	
	@FindBy(name  = "password")
	WebElement txt_password;
	
	@FindBy(name  = "password_confirmation")
	WebElement txt_passwordconfirm;
	
	@FindBy(xpath  = "//button[@title='Create an Account']")
	WebElement btn_CreateAccount;
	
	@FindBy(xpath  = "//div[@role='alert']//div/div")
	WebElement lbl_DuplicateEmailmessage;
	
	@FindBy(id  = "email_address-error")
	WebElement lbl_emailaddress_error;
	
	@FindBy(id  = "password-error")
	WebElement lbl_password_error;
	
	
	

	public CustomerRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	Faker testdata = new Faker();

	//write the methods to perform the actions on the elements
	public void validate_CustomerRegistrationPage() {
		Assert.assertEquals(getDriver().getTitle(), "Create New Customer Account");
	}
	
	public void enter_PersonalInformation(String fName,String lName) {
		enter_firstname(fName);
		enter_secondname(lName);
	}
	
	public void enter_firstname(String fName)
	{
		CommonFunctions.waitVisibilityofElement(txt_firstname);
		if(fName.equals("autotestdata"))
		{
			String fakerfName = testdata.name().firstName();
			messageHandler.log("Fake First Name : "+fakerfName);
			txt_firstname.sendKeys(fakerfName);
		}
		else
		{	
			txt_firstname.sendKeys(fName);
		}
	}
	
	public void enter_secondname(String lName)
	{
		if(lName.equals("autotestdata"))
		{
			String fakerlName = testdata.name().lastName();
			messageHandler.log("Fake Last Name : "+fakerlName);
			txt_lastname.sendKeys(fakerlName);
		}
		else
		{	
			txt_lastname.sendKeys(lName);
		}
	}
		

	
	public void enter_SignInInformation(String email,String input_password)
	{
		enter_email(email);
		enter_password(input_password);
	}
	
	public void enter_email(String email)
	{
		if(email.equals("autotestdata"))
		{
			String fakeremail = testdata.internet().emailAddress();
			messageHandler.log("Fake email address : "+fakeremail);
			txt_email.sendKeys(fakeremail);
		}
		else
		{	
			txt_email.sendKeys(email);
		}
		
	}
	
	public void enter_password(String input_password)
	{
		if(input_password.equals("autotestdata"))
		{
			password = testdata.internet().password(8, 10, true);
			messageHandler.log("Fake password : "+password);
			txt_password.sendKeys(password);
		}
		else
		{	
			txt_password.sendKeys(input_password);
		}
	}
	
	public void confirm_password(String input_password)
	{
		if(input_password.equals("autotestdata"))
		{
			txt_passwordconfirm.sendKeys(password);
		}
		else
		{	
			txt_passwordconfirm.sendKeys(input_password);
		}
	}
	
	public void click_CreateAccountButon()
	{
		btn_CreateAccount.click();
	}
	
	public void validate_DuplicateEmailmessage()
	{
		Assert.assertEquals(lbl_DuplicateEmailmessage.getText(), "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
		
		
	}
	
	public void validate_mandatory_field_message()
	{
		List<WebElement> elements = getDriver().findElements(By.xpath("//div[text()='This is a required field.']"));
		int numberOfElements = elements.size();
		Assert.assertTrue(numberOfElements > 0, "No elements found with the text 'This is a required field.'");
	}
	
	public void validate_email_error()
	{
		Assert.assertEquals(lbl_emailaddress_error.getText(), "Please enter a valid email address (Ex: johndoe@domain.com).");	
	}
	
	public void validate_password_error()
	{
		Assert.assertEquals(lbl_password_error.getText(), "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.");	
	}
	
	public void validate_MyAccountPage() {
		Assert.assertEquals(getDriver().getTitle(), "My Account");
	}
	

}

