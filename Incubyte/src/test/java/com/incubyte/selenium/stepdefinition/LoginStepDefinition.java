package com.incubyte.selenium.stepdefinition;


import java.io.InputStream;

import com.incubyte.selenium.utility.CommonFunctions;
import com.incubyte.selenium.utility.DriverIntialization;
import com.incubyte.selenium.page.CustomerRegistrationPage;
import com.incubyte.selenium.page.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefinition extends DriverIntialization {

	CustomerRegistrationPage CustomerRegistrationPage = new CustomerRegistrationPage(DriverIntialization.getDriver());
	LoginPage LoginPage = new LoginPage(DriverIntialization.getDriver());
	public static InputStream loadFileAsStream(String file) {
		return CommonFunctions.class.getResourceAsStream(file);
	}

	@Then("user should be able to see the Login Page")
	public void user_should_be_able_to_see_the_login_page() {
		LoginPage.validate_LoginPage();
	}
	
	@When("user enters emails as {string}")
	public void user_enters_emails_as(String email) {
		LoginPage.enter_email(email);
	}
	
	@When("enters password as {string}")
	public void enters_password_as(String password) {
		LoginPage.enter_password(password);
	}
	
	@When("click on Signin button")
	public void click_on_signin_button() {
		LoginPage.click_on_sigin();
	}
	
	@Then("user should be navigated to the Home Page")
	public void user_should_be_navigated_to_the_home_page() {
		LoginPage.validateHomePage();
	}
	
	@Then("user should be able to see the invalid login message")
	public void user_should_be_able_to_see_the_invalid_login_message() {
		LoginPage.validate_invalidlogin_message();
	}


}
