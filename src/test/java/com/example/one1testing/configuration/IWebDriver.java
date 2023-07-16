package com.example.one1testing.configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IWebDriver {

    protected WebDriver driver;

    public IWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitUntilElementExist(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElement findElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> findElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

}
