package com.example.one1testing.objects;

import com.example.one1testing.configuration.IWebDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPageObjects extends IWebDriver {
    public ProductPageObjects(WebDriver driver) {
        super(driver);
    }
    public WebElement getProductsButton(){
        return waitUntilElementExist("//li/a[@href='/products']");
    }
    public WebElement getAllProductsPageTitle(){
        return waitUntilElementExist("//h2[text()='All Products']");
    }
    public List<WebElement> getProductsList(){
        try {
            return  findElements("//div[@class='features_items']/div[@class='col-sm-4']");
        }catch (NoSuchElementException e){
            return null;
        }
    }
    public WebElement getViewProductButton(){
        return waitUntilElementExist("//a[@href='/product_details/1']");
    }
    public WebElement getProductDetailPage(){
        return waitUntilElementExist("//a[text()='Write Your Review']");
    }
    public WebElement getProductName(){
        return waitUntilElementExist("//p[contains(text(), 'Category:')]/../h2");
    }
    public WebElement getCategory(){
        return waitUntilElementExist("//p[contains(text(), 'Category:')]");
    }
    public WebElement getPrice(){
        return waitUntilElementExist("//p[contains(text(), 'Category:')]/../span/span");
    }
    public WebElement getAvailability(){
        return waitUntilElementExist("//b[text()='Availability:']/..");
    }
    public WebElement getCondition(){
        return waitUntilElementExist("//b[text()='Condition:']/..");
    }
    public WebElement getBrand(){
        return waitUntilElementExist("//b[text()='Brand:']/..");
    }
}
