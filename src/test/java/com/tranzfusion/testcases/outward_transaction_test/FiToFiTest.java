package com.tranzfusion.testcases.outward_transaction_test;

import com.tranzfusion.pages.HomePage;
import com.tranzfusion.pages.LoginPage;
import com.tranzfusion.pages.outward_transaction_page.FiToFiPage;
import com.tranzfusion.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FiToFiTest extends BaseTest {



    @Test       // testcase template=1
    public void FinToFinTransactionShouldBeSucceed() {

        LoginPage loginPage = page.getInstance(LoginPage.class)
               .doLogin(getMakerUsername(), getMakerPassword())
               .clickTransactionMenu()
               .clickFISubMenu()
               .selectMirrorAccount(1)
               .selectTransactionType(1)
               .selectPriority(1)
               .insertAmount(400000)
               .insertAgentInstructions("fdg dgd")
               .insertParticulars("fdf")
               .selectReceiverBank(3)
               .selectReceiverMirrorAccount(1)
               .clickOkBtn()
                .closePopup()
               .clickToHomeBtn()
              .clickProfile()
              .clickLogout();

        // Assert.assertTrue(fiToFiPage.hasTracerNo());

    }

   // @Test       // testcase template=2
    public void FinToFinTransactionShouldBeSucceed2() {
       FiToFiPage fiToFiPage  = page.getInstance(LoginPage.class)
                .doLogin(getMakerUsername(), getMakerPassword())
                .clickTransactionMenu()
                .clickFISubMenu()
                .selectMirrorAccount(1)
                .selectTransactionType(1)
                .selectPriority(1)
                .insertAmount(300000)
                .insertAgentInstructions("fdg dgd")
                .insertParticulars("fdf")
                .selectReceiverBank(3)
                .selectReceiverMirrorAccount(1)
                .clickOkBtn();
        Assert.assertTrue(fiToFiPage.hasTracerNo());
        LoginPage loginPage= fiToFiPage
                .closePopup()
                .clickToHomeBtn()
                .clickProfile()
                .clickLogout();


    }

    }

