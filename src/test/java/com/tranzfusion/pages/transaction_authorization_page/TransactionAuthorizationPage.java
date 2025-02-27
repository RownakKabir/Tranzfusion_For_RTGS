package com.tranzfusion.pages.transaction_authorization_page;

import com.tranzfusion.pages.BasePage;
import com.tranzfusion.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionAuthorizationPage extends BasePage {
    public TransactionAuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public TransactionAuthorizationPage selectUnAuthTrx(int transactionIndex) {
        By unauthorizedTransaction = By.cssSelector("contPlcHdrMasterHolder_gvUnauthTrans_ALLOW_TRANS_0");
        getWebElement(unauthorizedTransaction).click();
        return this;
    }

    public TransactionAuthorizationPage clickOkButton() {
        getWebElement(By.cssSelector("#contPlcHdrMasterHolder_btnOK")).click();
        return this;
    }

    //click homelogo to go homepage

    public HomePage clickToHomeBtn(){
        getWebElement(By.className("logo")).click();
        return getInstance(HomePage.class);
    }

    // verify if there is a success message or any result after clicking OK
    public boolean hasSuccessMessage() {
        return getWebElements(By.cssSelector("div[class='modal-body'] p")).size() > 0;
    }
}
