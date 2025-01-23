package com.incubyte.selenium.stepdefinition;

import java.io.InputStream;

import com.incubyte.selenium.utility.CommonFunctions;
import com.incubyte.selenium.utility.DriverIntialization;
import com.incubyte.selenium.page.CustomerRegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerRegistrationStepDefinition extends DriverIntialization {

	CustomerRegistrationPage CustomerRegistrationPage = new CustomerRegistrationPage(DriverIntialization.getDriver());

	public static InputStream loadFileAsStream(String file) {
		return CommonFunctions.class.getResourceAsStream(file);
	}

	@Then("user should be navigated to the Create New Customer Account Page")
	public void user_should_be_navigated_to_the_create_new_customer_account_page() {
		CustomerRegistrationPage.validate_CustomerRegistrationPage();
	}

	@When("user enters Personal Information with FirstName as {string} and LastName as {string}")
	public void user_enters_personal_information_with_first_name_as_and_last_name_as(String fName, String lName) {
		CustomerRegistrationPage.enter_PersonalInformation(fName, lName);
	}

	@When("enters SignIn Information with email id as {string} and the password as {string}")
	public void enters_sign_in_information_with_email_id_as_and_the_password_as(String email, String input_password) {
		CustomerRegistrationPage.enter_SignInInformation(email, input_password);
	}

	@When("confirms the password with {string}")
	public void confirms_the_password_with(String input_password) {
		CustomerRegistrationPage.confirm_password(input_password);
	}

	@When("clicks on the Create Account button")
	public void clicks_on_the_create_account_button() {
		CustomerRegistrationPage.click_CreateAccountButon();
	}

	@Then("user should be able to see the Existing Account Message")
	public void user_should_be_able_to_see_the_existing_account_message() {
		CustomerRegistrationPage.validate_DuplicateEmailmessage();
	}

	@Then("mandatory field error should appear on the screen")
	public void mandatory_field_error_should_appear_on_the_screen() {
		CustomerRegistrationPage.validate_mandatory_field_message();
	}

	@When("user enters first name as {string}")
	public void user_enters_first_name_as(String fName) {
		CustomerRegistrationPage.enter_firstname(fName);
	}

	@When("user enters last name as {string}")
	public void user_enters_last_name_as(String lName) {
		CustomerRegistrationPage.enter_secondname(lName);
	}

	@When("user enters emailid as {string}")
	public void user_enters_emailid_as(String email) {
		CustomerRegistrationPage.enter_email(email);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String inputpassword) {
		CustomerRegistrationPage.enter_password(inputpassword);
	}

	@Then("user should be able to see the email address error")
	public void user_should_be_able_to_see_the_email_address_error() {
		CustomerRegistrationPage.validate_email_error();
	}
	
	@Then("user should be able to see the password error")
	public void user_should_be_able_to_see_the_password_error() {
		CustomerRegistrationPage.validate_password_error();
	}
	
	@Then("user should be navigated to the MyAccount Page")
	public void user_should_be_navigated_to_the_my_account_page() {
		CustomerRegistrationPage.validate_MyAccountPage();
	}

}
