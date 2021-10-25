package com.stv.stepDefinitions;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class MainPageStep extends BasicFactoryTest {
    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginPage loginPage = new LoginPage();

    //01. Check active navigation tab

    @Given("Main page is loaded")
    public void mainPageIsLoaded() {
        mainFactoryPage.isAccountLinkDisplayed();
        throw new io.cucumber.java.PendingException();
    }
    @When("Find active navigation link")
    public void findActiveNavigationLink() {
        mainFactoryPage.getActiveNavLinkAddress();
        throw new io.cucumber.java.PendingException();
    }
    @Then("Check if the active navigation tab is Outlet}")
    public void checkIfTheActiveNavigationTabIs() {
        String expectedActiveLinkName = "Outlet";
        Assert.assertTrue(mainFactoryPage.isActiveLinkName(expectedActiveLinkName));
        throw new io.cucumber.java.PendingException();
    }

//    //Scenario: 02. Open the login page
//
//    @When("Click on element having id {string}")
//    public void click_on_element_having_id(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("Check if loaded page is Login page")
//    public void check_if_loaded_page_is_login_page() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @Then("Login page is loaded")
//    public void login_page_is_loaded() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
}

