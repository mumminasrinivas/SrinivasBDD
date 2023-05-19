package org.srinivas.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.srinivas.pages.HomePage;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;


public class HomepageStep {

    private WebDriver driver;
    private HomePage homepage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }
    @After
    public void teardown(){
        if (driver!=null) {
            driver.quit();
        }
    }
    @Given("I am on the reqres website home page")
    public void i_am_on_the_reqres_website_home_page() {
        driver.get("https://reqres.in");
        homepage = new HomePage(driver);
        Assert.assertEquals(homepage.checkHomepageImage(), true);

    }

    @Given("I have Navigated to Request and Response codes table")
    public void i_have_navigated_to_request_and_response_codes_table() {
        Assert.assertEquals(homepage.checkReqResTable(), true);
    }

    @When("I click on Key options available in left side")
    public void i_click_on_key_options_available_in_left_side() {
        Assert.assertEquals(homepage.checkReqResKeys(), true);
    }

    @Then("respective sample request and response details should be displayed")
    public void respective_sample_request_and_response_details_should_be_displayed() {
        //Assert.assertTrue(homepage.validateReqResCodes());
        Assert.assertEquals(true, homepage.validateReqResCodes());
    }

    @Given("I have seen support button on page")
    public void i_have_seen_support_button_on_page() {
        Assert.assertEquals(homepage.checkSupportButton(), true);
    }

    @When("I click on support button")
    public void i_click_on_support_button() {
        homepage.clickonSupportbutton();
    }

    @Then("Support page should be displayed")
    public void support_page_should_be_displayed() {
        Assert.assertEquals(homepage.checkSupportpageHeader(), true);
    }

    @Given("I am on support page")
    public void i_am_on_support_page() {
        Assert.assertEquals(homepage.checkSupportpageHeader(), true);
    }

    @When("I check the options on support page")
    public void i_check_the_options_on_support_page() {
        Assert.assertEquals(homepage.checkSupportoptiononetime(), true);
        Assert.assertEquals(homepage.checksupportoptionmonthly(), true);
    }

    @Then("I should be able to see the options for one-time and monthly support and upgrade button below the support page")
    public void i_should_be_able_to_see_the_options_for_one_time_and_monthly_support_and_upgrade_button_below_the_support_page() {
        Assert.assertEquals(homepage.checkUpgradeoption(), true);
    }

}
