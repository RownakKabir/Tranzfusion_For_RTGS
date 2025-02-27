package com.tranzfusion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage extends Page{
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle().trim();
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement element=null;
        try {
            element=driver.findElement(locator);

        }catch (Exception e){
            System.out.println(locator.toString() + " Select or Locator Not Found");
        }
        return element;
    }

    @Override
    public List<WebElement> getWebElements(By locator) {
        List<WebElement> elements=null;
        try {
            elements=driver.findElements(locator);

        }catch (Exception e){
            System.out.println(locator.toString() + " Select or Locator Not Found");
        }
        return elements;
    }

    @Override
    public void waitForElement(By locator) {
        try {

        }catch (Exception e){
            System.out.println(locator.toString() + " Select or Locator Not Found");
        }

    }
}
