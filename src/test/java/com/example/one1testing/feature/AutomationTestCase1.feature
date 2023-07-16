Feature: Register User

  Scenario: Verify if user registration works
    When user navigates to "https://automationexercise.com/"
    Then user can see the main page
    Then user clicks on "Signup/login" button
    And enters "Chyngyz" and "chyngy@gmail.com" address
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