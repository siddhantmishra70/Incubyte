#Author: siddhantmishra70@gmail.com
@Test
Feature: Customer Sign Up & Sign IN Functionality
  This feature conatains test scenarios around Sign Up and Sign In Functionality
  of the Luma Application

  @TC_001 @TC_002 @TC_003
  Scenario Outline: Verify Successful Account Creation
    Given user is on the Home Page of the application
    When user clicks on the Create an Account Link
    Then user should be navigated to the Create New Customer Account Page
    When user enters Personal Information with FirstName as "<FirstName>" and LastName as "<LastName>"
    And enters SignIn Information with email id as "<emailid>" and the password as "<password>"
    And confirms the password with "<password>"
    And clicks on the Create Account button
    Then user should be navigated to the MyAccount Page

    #use autotestdata for Automatic Data Generation
    Examples: 
      | FirstName    | LastName     | emailid      | password      |
      | Siddhant     | autotestdata | autotestdata | autotestdata  |
      | autotestdata | Mishra       | autotestdata | autotestdata  |
      | autotestdata | autotestdata | autotestdata | Siddhant@2876 |
      | autotestdata | autotestdata | autotestdata | autotestdata  |

  @TC_004
  Scenario Outline: Verify Duplicate Email ID Account Creation
    Given user is on the Home Page of the application
    When user clicks on the Create an Account Link
    Then user should be navigated to the Create New Customer Account Page
    When user enters Personal Information with FirstName as "<FirstName>" and LastName as "<LastName>"
    And enters SignIn Information with email id as "<emailid>" and the password as "<password>"
    And confirms the password with "<password>"
    And clicks on the Create Account button
    Then user should be able to see the Existing Account Message

    #use autotestdata for Automatic Data Generation
    Examples: 
      | FirstName | LastName | emailid           | password    |
      | Siddhant  | Mishra   | bbb1233@gmail.com | Test1234567 |

  @TC_005
  Scenario Outline: Verify Mandatory Fields for Account Creation
    Given user is on the Home Page of the application
    When user clicks on the Create an Account Link
    Then user should be navigated to the Create New Customer Account Page
    When clicks on the Create Account button
    Then mandatory field error should appear on the screen
    When user enters first name as "<FirstName>"
    And clicks on the Create Account button
    Then mandatory field error should appear on the screen
    And user enters last name as "<LastName>"
    And clicks on the Create Account button
    Then mandatory field error should appear on the screen
    And user enters emailid as "<emailid>"
    Then mandatory field error should appear on the screen
    And user enters password as "<password>"
    Then mandatory field error should appear on the screen

    #use autotestdata for Automatic Data Generation
    Examples: 
      | FirstName | LastName | emailid           | password    |
      | Siddhant  | Mishra   | bbb1233@gmail.com | Test1234567 |

  @TC_006
  Scenario Outline: Verify Invalid email address for Account Creation
    Given user is on the Home Page of the application
    When user clicks on the Create an Account Link
    Then user should be navigated to the Create New Customer Account Page
    When user enters Personal Information with FirstName as "<FirstName>" and LastName as "<LastName>"
    And enters SignIn Information with email id as "<emailid>" and the password as "<password>"
    And confirms the password with "<password>"
    And clicks on the Create Account button
    Then user should be able to see the email address error

    #use autotestdata for Automatic Data Generation
    Examples: 
      | FirstName | LastName     | emailid | password     |
      | Siddhant  | autotestdata |  123456 | autotestdata |

  @TC_007
  Scenario Outline: Validate Password with length less than eight
    Given user is on the Home Page of the application
    When user clicks on the Create an Account Link
    Then user should be navigated to the Create New Customer Account Page
    When user enters Personal Information with FirstName as "<FirstName>" and LastName as "<LastName>"
    And enters SignIn Information with email id as "<emailid>" and the password as "<password>"
    And confirms the password with "<password>"
    And clicks on the Create Account button
    Then user should be able to see the password error

    #use autotestdata for Automatic Data Generation
    Examples: 
      | FirstName | LastName     | emailid      | password |
      | Siddhant  | autotestdata | autotestdata |      123 |

  @TC_008
  Scenario Outline: Validate SignIn Functionality
    Given user is on the Home Page of the application
    When user clicks on Sign in Link
    Then user should be able to see the Login Page
    When user enters emails as "<emailid>"
    And enters password as "<password>"
    And click on Signin button
    Then user should be navigated to the Home Page

    Examples: 
      | emailid             | password   |
      | testertwo@gmail.com | Tester@123 |
      
  @TC_009
  Scenario Outline: Validate Invalid SignIn
    Given user is on the Home Page of the application
    When user clicks on Sign in Link
    Then user should be able to see the Login Page
    When user enters emails as "<emailid>"
    And enters password as "<password>"
    And click on Signin button
    Then user should be able to see the invalid login message

    Examples: 
      | emailid             | password   |
      | testertwo@gmail.com | Tester@345 |
