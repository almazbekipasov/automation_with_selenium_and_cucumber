Feature: Register And Login User

  Background: First steps to register and login
    When user navigates to "https://automationexercise.com/"
    Then user can see the main page
    Then user clicks on "Signup/login" button

  Scenario: Verify if user registration works
    And enters "register" name or password "Chyngyz" and email "chyngyz@gmail.com"
    When clicks on "Signup" button
    Then verifies that title "ENTER ACCOUNT INFORMATION" is visible
    And fills details: Title, Name, Email, Password, Date of Birth
    And selects checkbox "Sign up for our newsletter!"
    And selects checkbox "Receive special letters from our partners!"
    And fills details: First name, last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    When click "Create Account button"
    Then user can see ACCOUNT CREATED message
    When clicks on the "Continue" button
    Then user verify if logged in as "Chyngyz"
    When user clicks "Delete Account" button
    Then Verifies that "ACCOUNT DELETED!" is visible and click "Continue" button
    And user can see the main page

  Scenario: Verify if user can login with correct credentials
    And verifies that login title "Login to your account" is visible
    When enters "login" name or password "NewPassword" and email "chyngyz@gmail.com"
    Then clicks on login "login" button
    And user verify if logged in as "Ata Kuba"
    And user clicks on logout "logout" button
    And verify user is logged out

  Scenario: Verify if user cannot login with incorrect credentials
    And verifies that login title "Login to your account" is visible
    When enters "login" name or password "IncorrectPassword" and email "incorrectchyngyz@gmail.com"
    Then clicks on login "login" button
    And user can see credentials incorrect message

  Scenario: Verify if user cannot register with existing email
    And enters "register" name or password "Chyngyz" and email "chyngyz@gmail.com"
    When clicks on "Signup" button
    Then user can see email already exists message