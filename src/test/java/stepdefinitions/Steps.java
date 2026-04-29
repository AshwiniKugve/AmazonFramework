package stepdefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import utils.DriverFactory;

public class Steps {

    HomePage homePage;
    String product;

    @Given("user opens amazon website")
    public void user_opens_amazon_website() {
        homePage = new HomePage(DriverFactory.getDriver()); // ✅ FIXED
    }

    @When("user searches for {string}")
    public void user_searches_for(String product) {
        this.product = product;
        homePage.searchProduct(product);
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        homePage.verifySearchResults();
        homePage.verifyFirstProductVisible();
        homePage.verifyTitle(product);
    }
}