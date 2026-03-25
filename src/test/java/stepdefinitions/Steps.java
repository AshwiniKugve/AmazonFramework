package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.HomePage;

public class Steps extends BaseTest{

    HomePage homePage;
    String product;

    @Given("user opens amazon website")
    public void user_opens_amazon_website() {
        homePage = new HomePage(BaseTest.driver);  // ⭐ use static driver
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) {
        this.product = product;   // store it
        homePage.searchProduct(product);
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        homePage.verifySearchResults();
        homePage.verifyFirstProductVisible();
        homePage.verifyTitle(product);   // ✅ dynamic
    }
    
}