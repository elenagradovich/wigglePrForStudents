package com.stv.factory.factorypages;

import com.stv.framework.core.drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainFactoryPage extends FactoryPage {

    @FindBy(id = "accountLink")
    private WebElement accountLink;

    @FindBy(className = "bem-navigation-menu__list-link--clearance")
    private WebElement activeNavLink;

    @FindBy(xpath = "//button[contains(text(),'Accept All Cookies')]")
    private WebElement trustButton;

    public boolean isAccountLinkDisplayed(){
        return accountLink.isDisplayed();
    }

    public void clickOnAccountLink(){
        accountLink.click();
    }

    public void clickOnTrustButton(){
        trustButton.click();
    }

    public String getActiveLinkName() {
        return activeNavLink.getText();
    }
}
