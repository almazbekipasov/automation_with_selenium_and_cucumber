package com.example.one1testing.objects;

import com.example.one1testing.configuration.IWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProductObjects extends IWebDriver {
    public SearchProductObjects(WebDriver driver) {
        super(driver);
    }
    public WebElement getSearchInput() {
        return waitUntilElementExist("//input[@id='search_product']");
    }
    public WebElement getSearchButton(){
        return waitUntilElementExist("//button[@id='submit_search']");
    }
    public WebElement getSearchedProduct(){
        return waitUntilElementExist("//h2[text()='Searched Products']/..//h2/../../div[@class='productinfo text-center']/p");
    }
}
