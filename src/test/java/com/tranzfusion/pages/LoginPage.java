package com.tranzfusion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

 public LoginPage fillUsername (String username){
        getWebElement(By.cssSelector("#txtUserName")).sendKeys(username);
        return this;
}

    public LoginPage fillPassword (String password){
        getWebElement(By.cssSelector("#txtUserPassword")).sendKeys(password);
        return this;
    }

    // method for go to Homepage  from Loginpage

    public HomePage clickLoginBtnPass(){
        getWebElement(By.cssSelector("#btnLogIn")).click();
        return getInstance(HomePage.class);
    }

// method for fail login
    public LoginPage clickLoginBtnFail(){
        getWebElement(By.cssSelector("#btnLogIn")).click();
        return this;
    }


    public boolean hasError(){
        return getWebElements(By.className("error")).size()>0;
    }


    //login using method//
    public HomePage doLogin (String username, String password){
        return fillUsername(username)
                .fillPassword(password)
                .clickLoginBtnPass();
    }
}

