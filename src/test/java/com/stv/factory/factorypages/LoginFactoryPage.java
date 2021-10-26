package com.stv.factory.factorypages;

import com.stv.framework.core.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

public class LoginFactoryPage extends FactoryPage {
    @FindBy(className = "bem-checkout__container")
    private WebElement loginContainer;

    @FindBy(id = "qa-dual-register")
    private WebElement continueButton;

    @FindBy(id = "DualRegisterEmailModel_Email-error")
    private WebElement errorMessage;

    @FindBy(id = "DualRegisterEmailModel_Email")
    private WebElement emailField;

    @FindBy(xpath = "//h1[contains(text(),'New customer')]")
    private WebElement newCustomerTitle;

    @FindBy(id = "qa-register")
    private WebElement continueLoginButton;

    @FindBy(id = "RegisterModel_Password-error")
    private WebElement errorPasswordMessage;

    public boolean isLoginContainerDisplayed(){
        return loginContainer.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }
    public void clickOnContinueLoginButton(){
        continueLoginButton.click();
    }

    public void inputEmailValue(String email) {
        emailField.sendKeys(email);
    }

    public boolean isNewCustomerTitleDisplayed () {
        return newCustomerTitle.isDisplayed();
    }

    public void scrollPageDown(JavascriptExecutor js) {
        js.executeScript("arguments[0].scrollIntoView();", continueLoginButton);
    }

    public String getErrorPasswordMessage() {
        return errorPasswordMessage.getText();
    }
}
