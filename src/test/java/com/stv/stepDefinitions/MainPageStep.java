package com.stv.stepDefinitions;

import com.stv.factory.factorypages.LoginFactoryPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.framework.core.drivers.Driver;
import io.cucumber.java.en.*;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.After;

import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;
import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class MainPageStep {
    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginFactoryPage loginFactoryPage = new LoginFactoryPage();



    public static WebDriver getDriver() {
        return Driver.getDriver();
    }
    WebDriver driver = getDriver();


    public void closeBrowser() {
        getDriver().quit();
    }

    public void setUp() {
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private String activeLinkName = "";

    //Scenario: 01. Open Main page and follow to Login page
    @Given("Main page is loaded")
    public void mainPageIsLoaded() {
        setUp();
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.isAccountLinkDisplayed();
    }
    @When("Find active navigation link")
    public void findActiveNavigationLink() {
        activeLinkName = mainFactoryPage.getActiveLinkName().toLowerCase();
    }
    @Then("Check if the active navigation tab is {string}")
    public void checkIfTheActiveNavigationTabIs(String linkName) {
        String expectedActiveLinkName = linkName.toLowerCase();
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

    //Scenario: 02. Get warning message on Login page
    @Given("Login page is opened")
    public void loadLoginPage() {
        loginFactoryPage.isLoginContainerDisplayed();
    }

    @When("Click on Continue button")
    public void clickOnContinueButton() {
        loginFactoryPage.clickOnContinueButton();
    }
    @Then("Appeared warning message {string} over email field")
    public void getWarningMessage(String message) {
        String errorMessage = loginFactoryPage.getErrorMessage();
        Assert.assertEquals(errorMessage, message);
    }

    //Scenario Outline: 021. Input email address
    @When("Fill email field with value {string}")
    public void fillEmailField(String email) {
        loginFactoryPage.inputEmailValue(email);
        Sleep sleep = new Sleep();
        sleep.doSleep(1000);
    }
    @When("Press on Continue button")
    public void pressOnContinueButton() {
        loginFactoryPage.clickOnContinueButton();
    }
    @Then("Appeared New customer form")
    public void appearedNewCustomerForm() {
        Assert.assertTrue(loginFactoryPage.isNewCustomerTitleDisplayed());
    }

   //Scenario: 03. Submit empty form
    @Given("New customer form is loaded")
    public void newCustomerFormLoaded() {
        loginFactoryPage.isNewCustomerTitleDisplayed();
    }
    @When("Scroll down NewCustomer page")
    public void scrollDownNewCustomerPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        loginFactoryPage.scrollPageDown(js);
    }
    @When("Click on Continue Login button")
    public void clickOnContinueLoginButton() {
        loginFactoryPage.clickOnContinueLoginButton();
    }
    @Then("Warning message {string} is showed over email field")
    public void appearedErrorMessagesOverEmptyFields(String message) {
        Assert.assertEquals(loginFactoryPage.getErrorPasswordMessage(), message);
        closeBrowser();
    }
}

