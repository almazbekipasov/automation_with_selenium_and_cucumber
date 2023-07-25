package com.example.one1testing.objects;

import com.example.one1testing.configuration.IWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageSubscriptionObjects extends IWebDriver {
    public HomePageSubscriptionObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement getScrollDownFooter() {
        return waitUntilElementExist("//footer[@id='footer']");
    }
    public WebElement getTextSubscription(){
        return waitUntilElementExist("//h2[text()='Subscription']");
    }
    public WebElement getEmailInput(){
        return waitUntilElementExist("//input[@id='susbscribe_email']");
    }
    public WebElement getArrowButton(){
        return waitUntilElementExist("//button[@id='subscribe']");
    }
    public WebElement getSuccessMessage(){
        return waitUntilElementExist("//div[contains(text(), 'You have been successfully subscribed!')]");
    }
}
