package com.tranzfusion.testcases.transaction_authorization_test;

import com.tranzfusion.pages.LoginPage;
import com.tranzfusion.pages.transaction_authorization_page.TransactionAuthorizationPage;
import com.tranzfusion.testcases.BaseTest;
import org.testng.annotations.Test;

public class TransactionAuthorizationTest extends BaseTest {

    //@Test
    public void TransactionAuthorizationShouldBeSucceed() {


        TransactionAuthorizationPage transactionAuthorizationPage = page.getInstance(LoginPage.class)
                .doLogin(getCheckerUsername(), getCheckerPassword())
                        .clickTransactionMenu()
                        .clickTrxAuthSubMenu()
                        .selectUnAuthTrx(1)
                        .clickOkButton();



    }

    @Test
    public void TransactionAuthorizationShouldBeSucceed2() {


        LoginPage loginPage = page.getInstance(LoginPage.class)
                .doLogin(getCheckerUsername(), getCheckerPassword())
                .clickTransactionMenu()
                .clickTrxAuthSubMenu()
                //.selectUnAuthTrx(1)
                //.clickOkButton()
                .clickToHomeBtn()
                .clickProfile()
                .clickLogout();




    }




}
