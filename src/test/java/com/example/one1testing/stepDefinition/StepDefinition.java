package com.example.one1testing.stepDefinition;

import com.example.one1testing.objects.LoginObjects;
import com.example.one1testing.objects.RegisterObjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class StepDefinition {

    public WebDriver driver;
    public JavascriptExecutor js;
    public RegisterObjects register;
    public LoginObjects login;

    public StepDefinition(RegisterObjects register) {
        this.register = register;
    }

    public StepDefinition() {
    }

    @Before
    public void driverSetup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\atais\\IdeaProjects\\1Testing\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(-1900, 200));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    @When("user navigates to \"([^\"]*)\"$")
    public void user_navigates_to(String string) throws InterruptedException {
        driver.get(string);
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
        }else {
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

        if (checkboxTitle.equals("Sign up for our newsletter!")){
            register.getCheckbox("newsletter").click();
        }else if (checkboxTitle.equals("Receive special letters from our partners!")) {
            register.getCheckbox("optin").click();
        }else {
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

    @After()
    public void shutDown() {
        driver.quit();
    }

}
