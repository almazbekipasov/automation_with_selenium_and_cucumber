package com.example.one1testing.objects;

import com.example.one1testing.configuration.IWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsObjects extends IWebDriver {

    public ContactUsObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement getContactUsButton() {
        return waitUntilElementExist("//a[@href='/contact_us']");
    }

    public WebElement getInTouchTitle() {
        return waitUntilElementExist("//h2[text()='Get In Touch']");
    }

    public WebElement getNameInput() {
        return waitUntilElementExist("//input[@name='name']");
    }

    public WebElement getEmailInput() {
        return waitUntilElementExist("//input[@type='email']");
    }

    public WebElement getSubjectInput() {
        return waitUntilElementExist("//input[@name='subject']");
    }

    public WebElement getMessageInput() {
        return waitUntilElementExist("//textarea[@name='message']");
    }

    public WebElement getSubmitButton() {
        return waitUntilElementExist("//input[@type='submit']");
    }
    public WebElement getSuccessMessageText() {
        return waitUntilElementExist("//h2[text()='Get In Touch']/../div[text()='Success! Your details have been submitted successfully.']");
    }
    public WebElement getHomeButton() {
        return waitUntilElementExist("//div[@id='form-section']/a[@href='/']");
    }
}
