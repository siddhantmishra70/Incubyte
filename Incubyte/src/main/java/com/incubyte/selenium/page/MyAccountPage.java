package com.incubyte.selenium.page;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.incubyte.selenium.utility.CommonFunctions;
import com.incubyte.selenium.utility.MyTestResults;

public class MyAccountPage extends CommonFunctions {
	boolean temp = false;
	static MyTestResults results = new MyTestResults();

	
	
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//write the methods to perform the actions on the elements
	public void validate_MyAccountPage() {
		Assert.assertEquals(getDriver().getTitle(), "My Account");
	}

	
}

