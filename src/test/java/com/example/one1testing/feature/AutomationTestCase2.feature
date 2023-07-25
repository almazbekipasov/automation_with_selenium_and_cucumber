Feature: Contact Us Form and Test cases page

  Background: Main Steps
    When user navigates to "http://automationexercise.com"
    Then user can see the main page

  Scenario: Verify Contact Us form works
    And Click on Contact Us button
    And Verify GET IN TOUCH is visible
    And Enter name, email, subject and message
    And Upload file
    And Click Submit button
    And Click OK button
    And Verify success message Success! Your details have been submitted successfully. is visible
    And Click Home button and verify that landed to home page successfully

  Scenario: Verify Test Cases Page works
    And  Click on Test Cases button
    And  Verify user is navigated to test cases page successfully

  Scenario: Verify All Products and product detail page
    And Click on Products button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And The products list is visible
    And Click on View Product of first product
    And User is landed to product detail page
    And Verify that detail detail is visible: product name, category, price, availability, condition, brand

  Scenario: Search Product
    And Click on Products button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Enter product name in search input as "Blue Top"
    And  Click search button
    And Verify searched product "Blue Top" is visible
    And Verify all the products related to search are visible

  Scenario: Verify Subscription in home page
    And Scroll down to footer
    And Verify text SUBSCRIPTION
    And Enter email address in input
    And Click arrow button
    And Verify success message You have been successfully subscribed! is visible