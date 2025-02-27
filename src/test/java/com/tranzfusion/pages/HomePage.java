package com.tranzfusion.pages;

import com.tranzfusion.pages.outward_transaction_page.FiToFiPage;
import com.tranzfusion.pages.transaction_authorization_page.TransactionAuthorizationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean hasLogoutLink() {
        return getWebElements(By.cssSelector("#LogOutImg")).size() > 0;
    }


    // method for go to Menu bar from Homepage

    public HomePage clickTransactionMenu() {

        waitForElement(By.id("MenuTransactions"));
        getWebElement(By.id("MenuTransactions")).click();
        return getInstance(HomePage.class);
    }

        // method for go to FItoFI page from Homepage

        public FiToFiPage clickFISubMenu() {
            getWebElement(By.id("HyperLinkTransB2B")).click();
            return getInstance(FiToFiPage.class);
        }
    // method for go to Transaction Auth page from Homepage
    public TransactionAuthorizationPage clickTrxAuthSubMenu() {
        getWebElement(By.id("HyperLinkTransCheck")).click();
        return getInstance(TransactionAuthorizationPage.class);
    }

        //click on logout menu
    public HomePage clickProfile(){
        getWebElement(By.id("StockPricePanel")).click();
        return this;
    }

    // click on logout btn
    public LoginPage clickLogout() {
        getWebElement(By.cssSelector("#LogOutImg")).click();
        return getInstance(LoginPage.class);
    }




    }

