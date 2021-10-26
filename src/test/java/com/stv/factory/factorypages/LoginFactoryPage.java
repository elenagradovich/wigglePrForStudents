package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFactoryPage extends FactoryPage {
    @FindBy(className = "bem-checkout__container")
    private WebElement loginContainer;

    @FindBy(id = "qa-dual-register")
    private WebElement continueButton;

    @FindBy(id = "DualRegisterEmailModel_Email-error")
    private WebElement errorMessage;

    public boolean isLoginContainerDisplayed(){
        return loginContainer.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }
}
