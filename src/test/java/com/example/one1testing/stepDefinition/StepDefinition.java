package com.example.one1testing.stepDefinition;

import com.example.one1testing.objects.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class StepDefinition {

    public WebDriver driver;
    public JavascriptExecutor js;
    public RegisterObjects register;
    public LoginObjects login;
    public ContactUsObjects contactUs;
    public TestCasesObjects testCasesPage;
    public ProductPageObjects productPage;
    public SearchProductObjects searchProduct;
    public HomePageSubscriptionObjects homePageSubscription;

    public StepDefinition(RegisterObjects register) {
        this.register = register;
    }

    public StepDefinition() {
    }

    @Before
    public void driverSetup() {

        System.setProperty("webdriver.chrome.driver", "/home/ata/IdeaProjects/selenium_with_cucumber/src/test/resources/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().setPosition(new Point(-1900, 200));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    @When("user navigates to \"([^\"]*)\"$")
    public void user_navigates_to(String url) throws InterruptedException {
        driver.get(url);
    }

    @Then("user can see the main page")
    public void user_can_see_the_main_page() {

        register = new RegisterObjects(driver);
        String expectedTitle = "FEATURES ITEMS";
        String actualTitle = register.getMainPageTitle().getText();
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Then("user clicks on \"([^\"]*)\" button$")
    public void user_clicks_sign_up_and_sing_in_on_button(String string) throws InterruptedException {

        register.getSingUpAndLoginButton().click();

    }

    @Then("enters \"([^\"]*)\" name or password \"([^\"]*)\" and email \"([^\"]*)\"$")
    public void enters_name_and_email_address(String loginOrRegister, String nameOrPassword, String emailAddress) {

        if (loginOrRegister.equals("register")) {
            register.getSignUpNameInput().sendKeys(nameOrPassword);
            register.getSignUpEmailAddressInput().sendKeys(emailAddress);
        } else if (loginOrRegister.equals("login")) {
            login.getEmailAddressInput().sendKeys(emailAddress);
            login.getPasswordInput().sendKeys(nameOrPassword);
        } else {
            throw new NoSuchElementException("Couldn't find such an element! Nor login, nor register");
        }

    }

    @When("clicks on \"([^\"]*)\" button$")
    public void clicks_on_button(String string) throws InterruptedException {

        register.getSignUpButton().click();

    }

    @Then("verifies that title \"([^\"]*)\" is visible$")
    public void verifies_that_title_is_visible(String expected) throws InterruptedException {

        if (register.emailAlreadyExistTitle().equals("Email Address already exist!")) {
            System.out.println("CHANGING EMAIL BECAUSE IT EXISTS");
            register.getSignUpEmailAddressInput().clear();
            register.getSignUpNameInput().clear();
            enters_name_and_email_address("register", "Chyngyz", "chyngy" + RandomStringUtils.randomNumeric(7) + "@gmail.com");
            clicks_on_button("");
        }

        String actualTitle = register.getInsertAccountInfoTitle().getText();

        Assert.assertEquals(actualTitle, expected);

    }

    @Then("fills details: Title, Name, Email, Password, Date of Birth")
    public void fills_details_title_name_email_password_date_of_birth() throws InterruptedException {
        register.getTitleRadioButton().click();
        register.getPasswordInput().sendKeys("NewPassword");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", register.getDayDropDown());
        register.getDayDropDown().click();
        Thread.sleep(500);
        register.getDayOption().click();
        register.getMonthDropDown().click();
        Thread.sleep(500);
        register.getMonthOption().click();
        register.getYearDropDown().click();
        Thread.sleep(500);
        register.getYearOption().click();

    }

    @Then("selects checkbox \"([^\"]*)\"$")
    public void clicks_checkbox(String checkboxTitle) {

        if (checkboxTitle.equals("Sign up for our newsletter!")) {
            register.getCheckbox("newsletter").click();
        } else if (checkboxTitle.equals("Receive special letters from our partners!")) {
            register.getCheckbox("optin").click();
        } else {
            /* Do nothing */
        }


    }

    @Then("fills details: First name, last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fills_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() throws InterruptedException {

        register.getFirstNameInput().sendKeys("Chyngyz");
        register.getLastNameInput().sendKeys("Kamarov");
        register.getCompanyInput().sendKeys("MukAtAy");
        register.getAddressOne().sendKeys("Michigan Ave");
        register.getAddressTwo().sendKeys("Unit 18");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", register.getCountryDropdown());
        js.executeScript("arguments[0].click();", register.getCountryDropdown());
        register.getCountryOption().click();
        register.getStateInput().sendKeys("Illinois");
        register.getCityInput().sendKeys("Chicago");
        register.getZipcodeInput().sendKeys("60606");
        register.getMobileNumberInput().sendKeys("+14129990000");

    }

    @When("click {string}")
    public void click(String string) {

        register.getCreateAccountButton().click();

    }

    @Then("user can see ACCOUNT CREATED message")
    public void user_can_see_account_created_message() {

        String actualTitle = register.getAccountCreatedTitle().getText();
        String expectedTitle = "ACCOUNT CREATED!";

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @When("clicks on the \"([^\"]*)\" button$")
    public void clicks_button(String string) throws InterruptedException {

        register.getContinueButton().click();

    }

    @Then("user verify if logged in as \"([^\"]*)\"$")
    public void user_verify_if_logged_in_as(String expectedUsername) {

        String actualUsername = register.getLoggedUsername().getText();

        Assert.assertEquals(actualUsername, "Logged in as " + expectedUsername);

    }

    @When("user clicks \"([^\"]*)\" button$")
    public void user_clicks_button(String string) {

        register.getDeleteAccountButton().click();

    }

    @Then("Verifies that \"([^\"]*)\" is visible and click \"([^\"]*)\" button$")
    public void verifies_that_is_visible_and_click_button(String expectedTitle, String string2) throws InterruptedException {

        String actualTitle = register.getAccountDeletedTitle().getText();

        Assert.assertEquals(actualTitle, expectedTitle);

        Thread.sleep(1000);

        register.getContinueButton().click();

    }

    @Then("verifies that login title \"([^\"]*)\" is visible$")
    public void verifies_that_login_title_is_visible(String expectedLoginFormTitle) {

        login = new LoginObjects(driver);

        String actualLoginFormTitle = login.getLoginFormTitle().getText();

        Assert.assertEquals(actualLoginFormTitle, expectedLoginFormTitle);

    }

    @Then("clicks on login \"([^\"]*)\" button$")
    public void clicks_on_login_button(String loginButton) {

        login.getLoginButton().click();

    }

    @Then("user clicks on logout \"([^\"]*)\" button$")
    public void user_clicks_on_logout_button(String logoutButton) {

        login.getLogoutButton().click();

    }

    @Then("verify user is logged out")
    public void verify_user_is_logged_out() {

        boolean logoutButtonIsVisible = login.isLogoutButtonVisible();

        Assert.assertFalse(logoutButtonIsVisible);

    }

    @Then("user can see credentials incorrect message")
    public void user_can_see_credentials_incorrect_message() {

        String expectedIncorrectMessage = "Your email or password is incorrect!";
        String actualIncorrectMessage = login.getIncorrectCredentialsMessage().getText();

        Assert.assertEquals(expectedIncorrectMessage, actualIncorrectMessage);

    }

    @Then("user can see email already exists message")
    public void user_can_see_email_already_exists_message() {

        String expectedMessage = "Email Address already exist!";
        String actualMessage = register.emailAlreadyExistTitle();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Then("Click on Contact Us button")
    public void click_on_contact_us_button() {
        contactUs = new ContactUsObjects(driver);
        contactUs.getContactUsButton().click();
    }

    @Then("Verify GET IN TOUCH is visible")
    public void verify_get_in_touch_is_visible() {
        String actualTitle = contactUs.getInTouchTitle().getText();
        String expectedTitle = "GET IN TOUCH";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Then("Enter name, email, subject and message")
    public void enter_name_email_subject_and_message() {
        contactUs.getNameInput().sendKeys("Almazbek");
        contactUs.getEmailInput().sendKeys("ads@mail.ru");
        contactUs.getSubjectInput().sendKeys("Subject Text");
        contactUs.getMessageInput().sendKeys("Message Text");
    }

    @Then("Upload file")
    public void upload_file() {
// Todo:need to be done.
    }

    @Then("Click Submit button")
    public void click_submit_button() {
        contactUs.getSubmitButton().click();
    }

    @Then("Click OK button")
    public void click_ok_button() {
        driver.switchTo().alert().accept();
    }

    @Then("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verify_success_message_success_your_details_have_been_submitted_successfully_is_visible() {
        String actualText = contactUs.getSuccessMessageText().getText();
        String expectedText = "Success! Your details have been submitted successfully.";
        Assert.assertEquals(actualText, expectedText);
    }

    @Then("Click Home button and verify that landed to home page successfully")
    public void click_home_button_and_verify_that_landed_to_home_page_successfully() {
        contactUs.getHomeButton().click();
    }

    @Then("Click on Test Cases button")
    public void click_on_test_cases_button() {
        testCasesPage = new TestCasesObjects(driver);
        testCasesPage.getTestCasesButton().click();
    }

    @Then("Verify user is navigated to test cases page successfully")
    public void verify_user_is_navigated_to_test_cases_page_successfully() {
        String expectText = testCasesPage.getTestCasesPageTitle().getText();
        String actualText = "TEST CASES";
        Assert.assertEquals(expectText, actualText);
    }

    //todo: TEST CASE #8:
    @Then("Click on Products button")
    public void click_on_Products_button() {
        productPage = new ProductPageObjects(driver);
        productPage.getProductsButton().click();
    }

    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        String expectForm = productPage.getAllProductsPageTitle().getText();
        String actualForm = "ALL PRODUCTS";
        Assert.assertEquals(expectForm, actualForm);
    }

    @Then("The products list is visible")
    public void the_products_list_is_visible() {
        List<WebElement> productsList = productPage.getProductsList();
        if (productsList == null) {
            return;
        }
        Assert.assertTrue(productsList.size() > 0);
    }

    @Then("Click on View Product of first product")
    public void click_on_View_Product_of_first_product() throws InterruptedException {
        List<WebElement> productsList = productPage.getProductsList();
        if (productsList == null) {
            return;
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productPage.getViewProductButton());
        productPage.getViewProductButton().click();

    }

    @Then("User is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
        List<WebElement> productsList = productPage.getProductsList();
        if (productsList == null) {
            return;
        }
        String actualText = productPage.getProductDetailPage().getText().toLowerCase();
        Assert.assertTrue(actualText.contains("write your"));

    }

    @Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verify_that_detail_detail_is_visible_product_name_category_price_availability_condition_brand() {
        List<WebElement> productsList = productPage.getProductsList();
        if (productsList == null) {
            return;
        }
        String actualName = productPage.getProductName().getText();
        String actualCategory = productPage.getCategory().getText();
        String actualPrice = productPage.getPrice().getText();
        String actualAvailable = productPage.getAvailability().getText();
        String actualCondition = productPage.getCondition().getText();
        String actualBrand = productPage.getBrand().getText();

        String expectedBrand = "Brand: Polo";
        String expectedName = "Blue Top";
        String expectedCategory = "Category: Women > Tops";
        String expectedPrice = "Rs. 500";
        String expectedAvailable = "Availability: In Stock";
        String expectedCondition = "Condition: New";

        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedCategory, actualCategory);
        Assert.assertEquals(expectedPrice, actualPrice);
        Assert.assertEquals(expectedAvailable, actualAvailable);
        Assert.assertEquals(expectedCondition, actualCondition);
    }

    //todo: TEST CASE #9
    @Then("Enter product name in search input as \"([^\"]*)\"$")
    public void enter_product_name_in_search_input(String searchProductName) {
        searchProduct = new SearchProductObjects(driver);
        searchProduct.getSearchInput().click();
        searchProduct.getSearchInput().sendKeys(searchProductName);
    }

    @Then("Click search button")
    public void click_search_button() {
        searchProduct.getSearchButton().click();
    }

    @Then("Verify searched product \"([^\"]*)\" is visible$")
    public void verify_searched_product_is_visible(String expectedProductName) {
        String actualText = searchProduct.getSearchedProduct().getText();
        Assert.assertEquals(expectedProductName, actualText);
    }

    @Then("Verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() {
        searchProduct.getSearchInput().click();
        searchProduct.getSearchInput().clear();
        enter_product_name_in_search_input("Men Tshirt");
        click_search_button();
        verify_searched_product_is_visible("Men Tshirt");

        searchProduct.getSearchInput().click();
        searchProduct.getSearchInput().clear();
        enter_product_name_in_search_input("Winter Top");
        click_search_button();
        verify_searched_product_is_visible("Winter Top");

    }

    // Test Case #10
    @Then("Scroll down to footer")
    public void scroll_down_to_footer() {
        homePageSubscription = new HomePageSubscriptionObjects(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homePageSubscription.getScrollDownFooter());
    }

    @Then("Verify text SUBSCRIPTION")
    public void verify_text_subscription() {
        String actualTitle = homePageSubscription.getTextSubscription().getText();
        String expectedTitle = "SUBSCRIPTION";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("Enter email address in input")
    public void enter_email_address_in_input() {
        homePageSubscription.getEmailInput().sendKeys("email@email.ru");
    }

    @Then("Click arrow button")
    public void click_arrow_button() {
        homePageSubscription.getArrowButton().click();
    }

    @Then("Verify success message You have been successfully subscribed! is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() throws InterruptedException {
       boolean messagePoppedUp = homePageSubscription.getSuccessMessage().isDisplayed();
       Assert.assertTrue(messagePoppedUp);
        Thread.sleep(6000);
    }


    @After()
    public void shutDown() throws InterruptedException {

        driver.quit();
    }

}
