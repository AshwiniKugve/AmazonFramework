package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import base.BasePage;

public class HomePage extends BasePage {

	//Added search feature branch
    // Locators
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchBtn = By.id("nav-search-submit-button");

    // Result locators
    private By resultsContainer = By.cssSelector("div.s-main-slot");
    private By firstProduct = By.cssSelector("div[data-component-type='s-search-result']");

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Action
    public void searchProduct(String product) {
        sendKeys(searchBox, product);
        click(searchBtn);
    }

    // ✅ Assertion 1: Results displayed
    public void verifySearchResults() {
        waitForVisibility(resultsContainer);
        boolean isDisplayed = driver.findElement(resultsContainer).isDisplayed();
        Assert.assertTrue(isDisplayed, "Search results are NOT displayed!");
    }

    // ✅ Assertion 2: First product visible
    public void verifyFirstProductVisible() {
        waitForVisibility(firstProduct);
        boolean isDisplayed = driver.findElement(firstProduct).isDisplayed();
        Assert.assertTrue(isDisplayed, "First product is NOT visible!");
    }

    // ✅ Assertion 3: Title contains product name
    public void verifyTitle(String product) {
        String title = driver.getTitle();
        Assert.assertTrue(title.toLowerCase().contains(product.toLowerCase()),
                "Page title does NOT contain searched product!");
    }
}