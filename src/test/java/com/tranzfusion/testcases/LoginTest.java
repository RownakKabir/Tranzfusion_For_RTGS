package com.tranzfusion.testcases;

import com.tranzfusion.pages.HomePage;
import com.tranzfusion.pages.LoginPage;
import com.tranzfusion.util.General;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void doLoginWithUsernameShouldFail(){
        LoginPage loginPage=page.getInstance(LoginPage.class)
                .fillUsername(getMakerUsername())
                .clickLoginBtnFail();
        Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void doLoginShouldPass(){
        HomePage homePage=page.getInstance(LoginPage.class)
                .fillUsername(getMakerUsername())
                .fillPassword(getMakerPassword())
                .clickLoginBtnPass();
        Assert.assertTrue(homePage.hasLogoutLink());

    }



}
