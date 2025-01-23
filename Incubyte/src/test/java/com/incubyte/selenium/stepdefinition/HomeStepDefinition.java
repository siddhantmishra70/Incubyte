package com.incubyte.selenium.stepdefinition;


import java.io.InputStream;

import com.incubyte.selenium.utility.CommonFunctions;
import com.incubyte.selenium.utility.DriverIntialization;
import com.incubyte.selenium.page.CustomerRegistrationPage;
import com.incubyte.selenium.page.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class HomeStepDefinition extends DriverIntialization {

	CustomerRegistrationPage CustomerRegistrationPage = new CustomerRegistrationPage(DriverIntialization.getDriver());
	HomePage HomePage = new HomePage(DriverIntialization.getDriver());
	public static InputStream loadFileAsStream(String file) {
		return CommonFunctions.class.getResourceAsStream(file);
	}

	@Given("user is on the Home Page of the application")
	public void user_is_on_the_home_page_of_the_application() {
	    HomePage.validate_homepage();
	}
	
	@When("user clicks on the Create an Account Link")
	public void user_clicks_on_the_create_an_account_link() {
	    HomePage.click_CreateAccount();
	}
	
	@When("user clicks on Sign in Link")
	public void user_clicks_on_sign_in_link() {
		HomePage.click_Signin();
	}

}
