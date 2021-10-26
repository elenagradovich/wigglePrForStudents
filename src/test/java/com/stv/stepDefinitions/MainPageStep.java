package com.stv.stepDefinitions;

import com.stv.factory.factorypages.LoginFactoryPage;
import com.stv.factory.factorypages.MainFactoryPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.stv.factory.factorytests.BasicFactoryTest;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class MainPageStep extends BasicFactoryTest {
    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginFactoryPage loginFactoryPage = new LoginFactoryPage();

    private String activeLinkName = "";

    @AfterClass()
    public void afterClass() {
        getDriver().quit();
    }

    @Given("Main page is loaded")
    public void mainPageIsLoaded() {
        WebDriver driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.isAccountLinkDisplayed();
    }
    @When("Find active navigation link")
    public void findActiveNavigationLink() {
        activeLinkName = mainFactoryPage.getActiveLinkName().toLowerCase();
    }
    @Then("Check if the active navigation tab is {string}")
    public void checkIfTheActiveNavigationTabIs(String string) {
        String expectedActiveLinkName = string.toLowerCase();
        Assert.assertEquals(activeLinkName, expectedActiveLinkName);
    }
    @When("Click on login link")
    public void clickOnLoginLink() {
        mainFactoryPage.clickOnAccountLink();
    }
    @Then("Login page is loaded")
    public void loginPageIsLoaded() {
        Assert.assertTrue(loginFactoryPage.isLoginContainerDisplayed());
    }
}

