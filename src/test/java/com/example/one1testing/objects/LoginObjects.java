package com.example.one1testing.objects;

import com.example.one1testing.configuration.IWebDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects extends IWebDriver {
    public LoginObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginFormTitle() {
        return waitUntilElementExist("//h2[text()='Login to your account']");
    }

    public WebElement getEmailAddressInput() {
        return waitUntilElementExist("//h2[text()='Login to your account']/..//input[@name='email']");
    }

    public WebElement getPasswordInput() {
        return waitUntilElementExist("//input[@name='password']");
    }

    public WebElement getLoginButton() {
        return waitUntilElementExist("//button[text()='Login']");
    }

    public WebElement getLogoutButton() {
        return waitUntilElementExist("//li/a[@href='/logout']");
    }

    public Boolean isLogoutButtonVisible() {
        try {
            findElement("//li/a[@href='/logout']");
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getIncorrectCredentialsMessage() {
        return waitUntilElementExist("//p[text()='Your email or password is incorrect!']");
    }

}
