package com.example.one1testing.objects;

import com.example.one1testing.configuration.IWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasesObjects extends IWebDriver {
    public TestCasesObjects(WebDriver driver) {
        super(driver);
    }
    public WebElement getTestCasesButton(){
        return waitUntilElementExist("//li/a[@href='/test_cases']");
    }
    public WebElement getTestCasesPageTitle(){
        return waitUntilElementExist("//b[text()='Test Cases']");
    }
}
