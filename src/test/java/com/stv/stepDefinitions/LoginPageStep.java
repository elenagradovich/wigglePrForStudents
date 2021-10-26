package com.stv.stepDefinitions;

import com.stv.framework.core.drivers.Driver;
import io.cucumber.java.en.*;

import com.stv.factory.factorypages.LoginFactoryPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import com.stv.factory.factorytests.BasicFactoryTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import static com.stv.framework.core.lib.WigglePageURLs.LOGIN_URL;

public class LoginPageStep {
  LoginFactoryPage loginFactoryPage = new LoginFactoryPage();
  public static WebDriver getDriver() {
      return Driver.getDriver();
    }

    @AfterClass()
    public void afterClass() {
      getDriver().quit();
    }


    //Scenario: 01. Get warning message on Login page
    @Given("Login page is opened")
    public void loadLoginPage() {
        WebDriver driver = getDriver();
        driver.get(LOGIN_URL);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginFactoryPage.isLoginContainerDisplayed();
    }

    @When("Click on Continue button")
    public void clickOnContinueButton() {
      loginFactoryPage.clickOnContinueButton();
    }
    @Then("Appeared warning message {string} over email field")
    public void getWarningMessage(String string) {
        String errorMessage = loginFactoryPage.getErrorMessage();
        Assert.assertEquals(errorMessage, string);
    }
//
//    //Scenario Outline: 031. Input email address
//    @When("Fill email field with email value test_{int}@gmail.com")
//    public void fill_email_field_with_email_value_test_gmail_com(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("Click on button {string} with id {string}")
//    public void click_on_button_with_id(String string, String string2) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("Appeared New customer form")
//    public void appeared_new_customer_form() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    //Scenario: 032. Submit empty form
//    @Given("New customer form is loaded")
//    public void new_customer_form_is_loaded() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("Scroll down the page")
//    public void scroll_down_the_page() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("Click on element having id {string}")
//    public void click_on_element_having_id(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("Appeared warning message {string} in element id {string}")
//    public void appeared_warning_message_in_element_id(String string, String string2) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

}
