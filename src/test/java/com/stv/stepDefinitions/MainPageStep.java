package com.stv.stepDefinitions;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.framework.core.drivers.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.START_URL;


public class MainPageStep {
    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginPage loginPage = new LoginPage();

    private String activeLinkName = "";

    public static WebDriver getDriver() {
        return Driver.getDriver();
    }

    @Before()
    public void setUp() {
        WebDriver driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After()
    public void afterClass() {
        getDriver().quit();
    }

    @Given("Main page is loaded")
    public void mainPageIsLoaded() {
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
    public void clickOnLink() {
        mainFactoryPage.clickOnAccountLink();
    }
    @Then("Login page is loaded")
    public void loginPageIsLoaded() {
        Assert.assertTrue(loginPage.isLoginContainerDisplayed());
    }
}

