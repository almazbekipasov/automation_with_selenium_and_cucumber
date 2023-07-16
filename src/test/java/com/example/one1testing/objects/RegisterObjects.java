package com.example.one1testing.objects;

import com.example.one1testing.configuration.IWebDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterObjects extends IWebDriver {

    public RegisterObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement getMainPageTitle() {
        return waitUntilElementExist ("//h2[contains(text(), 'Features Items')]");
    }
    public WebElement getSingUpAndLoginButton() {
        return waitUntilElementExist("//a[@href='/login']");
    }
    public WebElement getSignUpNameInput() {
        return waitUntilElementExist("//input[@name='name']");
    }
    public WebElement getSignUpEmailAddressInput() {
        return waitUntilElementExist("//h2[text()='New User Signup!']/..//input[@name='email']");
    }

    public WebElement getSignUpButton() {
        return waitUntilElementExist("//button[text()='Signup']");
    }

    public WebElement getInsertAccountInfoTitle() {
        return waitUntilElementExist("//b[text()='Enter Account Information']");
    }

    public WebElement getTitleRadioButton() {
        return waitUntilElementExist("(//input[@name='title']) [1]");
    }

    public WebElement getPasswordInput() {
        return waitUntilElementExist("//input[@name='password']");
    }

    public WebElement getDayDropDown() {
        return waitUntilElementExist("//select[@name='days']");
    }

    public WebElement getDayOption() {
        return waitUntilElementExist("(//select[@name='days']/option) [2]");
    }

    public WebElement getMonthDropDown() {
        return waitUntilElementExist("//select[@name='months']");
    }

    public WebElement getMonthOption() {
        return waitUntilElementExist("(//select[@name='months']/option) [5]");
    }

    public WebElement getYearDropDown() {
        return waitUntilElementExist("//select[@name='years']");
    }

    public WebElement getYearOption() {
        return waitUntilElementExist("//select[@name='years']/option[@value='2002']");
    }

    public WebElement getCheckbox(String checkboxTitle) {
        return waitUntilElementExist("//input[@name='" + checkboxTitle + "']");
    }

    public WebElement getFirstNameInput() {
        return waitUntilElementExist("//input[@name='first_name']");
    }

    public WebElement getLastNameInput() {
        return waitUntilElementExist("//input[@name='last_name']");
    }

    public WebElement getCompanyInput() {
        return waitUntilElementExist("//input[@name='company']");
    }

    public WebElement getAddressOne() {
        return waitUntilElementExist("//input[@name='address1']");
    }

    public WebElement getAddressTwo() {
        return waitUntilElementExist("//input[@name='address2']");
    }

    public WebElement getCountryDropdown() {
        return waitUntilElementExist("//select[@name='country']");
    }

    public WebElement getCountryOption() {
        return waitUntilElementExist("//select[@name='country']/option[@value='United States']");
    }

    public WebElement getStateInput() {
        return waitUntilElementExist("//input[@name='state']");
    }

    public WebElement getCityInput() {
        return waitUntilElementExist("//input[@name='city']");
    }

    public WebElement getZipcodeInput() {
        return waitUntilElementExist("//input[@name='zipcode']");
    }

    public WebElement getMobileNumberInput() {
        return waitUntilElementExist("//input[@name='mobile_number']");
    }

    public WebElement getCreateAccountButton() {
        return waitUntilElementExist("//button[@data-qa='create-account']");
    }

    public WebElement getAccountCreatedTitle() {
        return waitUntilElementExist("//b[text()='Account Created!']");
    }

    public WebElement getContinueButton() {
        return waitUntilElementExist("//a[text()='Continue']");
    }

    public WebElement getLoggedUsername() {
        return waitUntilElementExist("//a[text()=' Logged in as ']");
    }

    public WebElement getDeleteAccountButton() {
        return waitUntilElementExist("//a[text()=' Delete Account']");
    }

    public WebElement getAccountDeletedTitle() {
        return waitUntilElementExist("//b[text()='Account Deleted!']");
    }
    public String emailAlreadyExistTitle() {
        try {
            return findElement("//p[text()='Email Address already exist!']").getText();
        }catch (NoSuchElementException e) {
            System.out.println("EMAIL ALREADY EXIST");
            return "";
        }

    }

}
