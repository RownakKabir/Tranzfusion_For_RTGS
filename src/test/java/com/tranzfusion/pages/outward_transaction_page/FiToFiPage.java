package com.tranzfusion.pages.outward_transaction_page;
import com.tranzfusion.pages.HomePage;
import com.tranzfusion.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FiToFiPage extends BasePage {

    public FiToFiPage(WebDriver driver) {
        super(driver);
    }

  public FiToFiPage selectMirrorAccount(int index){
        new Select(getWebElement(By.cssSelector("#contPlcHdrMasterHolder_FHddlAccountDebtor"))).selectByIndex(index);
        return this;

    }

    public FiToFiPage selectTransactionType(int index) {
        new Select(getWebElement(By.cssSelector("#contPlcHdrMasterHolder_FHddlAccountDebtor"))).selectByIndex(index);
        return this;

    }

    public FiToFiPage selectPriority(int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getWebElement(By.id("contPlcHdrMasterHolder_FHddlPriority"))).perform();
        waitForElement((By.id("contPlcHdrMasterHolder_FHddlPriority")));
        new Select(getWebElement(By.id("contPlcHdrMasterHolder_FHddlPriority"))).selectByIndex(index);
        return this;
    }

    public FiToFiPage insertAmount(double amount) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getWebElement(By.id("contPlcHdrMasterHolder_TFtxtAmountDebtor"))).perform();
        waitForElement((By.id("contPlcHdrMasterHolder_TFtxtAmountDebtor")));
        getWebElement(By.cssSelector("#contPlcHdrMasterHolder_TFtxtAmountDebtor")).sendKeys(Double.toString(amount));

        return this;
    }

    public FiToFiPage insertAgentInstructions(String intruct) {
        try {
            Thread.sleep(1000);
            By agentInstructionFItoFI = By.id("contPlcHdrMasterHolder_TFtxtInstructionForAgent");
            Actions actions = new Actions(driver);
            actions.moveToElement(getWebElement(agentInstructionFItoFI)).perform();
            getWebElement(agentInstructionFItoFI).click();
            getWebElement(agentInstructionFItoFI).sendKeys(intruct);
            return this;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public FiToFiPage insertParticulars(String particulars) {
        try {
            Thread.sleep(1000);
            By particularsFItoFI = By.id("contPlcHdrMasterHolder_TFtxtNarrationDebtor");
            Actions actions = new Actions(driver);
            actions.moveToElement(getWebElement(particularsFItoFI)).perform();
            getWebElement(particularsFItoFI).sendKeys(particulars);
            return this;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public FiToFiPage selectReceiverBank(int index) {
        new Actions(driver).moveToElement(getWebElement(By.id("contPlcHdrMasterHolder_FHddlBankCreditor"))).perform();
        waitForElement(By.id("contPlcHdrMasterHolder_FHddlBankCreditor"));
        new Select(getWebElement(By.id("contPlcHdrMasterHolder_FHddlBankCreditor"))).selectByIndex(index);
        return this;
    }

    public FiToFiPage selectReceiverMirrorAccount(int index) {
        new Actions(driver).moveToElement(getWebElement(By.id("contPlcHdrMasterHolder_FHddlBBAccountCreditor"))).perform();
        waitForElement(By.id("contPlcHdrMasterHolder_FHddlBBAccountCreditor"));
        new Select(getWebElement(By.cssSelector("#contPlcHdrMasterHolder_FHddlBBAccountCreditor"))).selectByIndex(index);
        return this;
    }

    public FiToFiPage clickOkBtn() {
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#contPlcHdrMasterHolder_btnOk"))).perform();
        getWebElement(By.cssSelector("#contPlcHdrMasterHolder_btnOk")).click();
        return this;

    }

    public boolean hasTracerNo(){
        return getWebElements(By.cssSelector("div[class='modal-body'] p")).size()>0;
    }

    // Close the success popup by clicking the close button
    public FiToFiPage closePopup() {
        getWebElement(By.cssSelector(".btn.btn-default")).click();
        return this;
    }

    //click homelogo to go homepage

    public HomePage clickToHomeBtn(){
        getWebElement(By.className("logo")).click();
        return getInstance(HomePage.class);
    }

}


