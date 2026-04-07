package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BasePage;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators using PageFactory

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchBtn;

    @FindBy(css = "div.s-main-slot")
    private WebElement resultsContainer;

    @FindBy(css = "div[data-component-type='s-search-result']")
    private WebElement firstProduct;


    // Action Method

    public void searchProduct(String product) {
        sendKeys(searchBox, product);
        click(searchBtn);
    }


    // Assertion 1: Results displayed

    public void verifySearchResults() {
        waitForVisibility(resultsContainer);
        Assert.assertTrue(resultsContainer.isDisplayed(),
                "Search results are NOT displayed!");
    }


    // Assertion 2: First product visible

    public void verifyFirstProductVisible() {
        waitForVisibility(firstProduct);
        Assert.assertTrue(firstProduct.isDisplayed(),
                "First product is NOT visible!");
    }


    // Assertion 3: Title validation

    public void verifyTitle(String product) {
        String title = getTitle();
        Assert.assertTrue(title.toLowerCase().contains(product.toLowerCase()),
                "Page title does NOT contain searched product!");
    }
}