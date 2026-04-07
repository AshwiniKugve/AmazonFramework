package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Wait for visibility
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for clickable
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Click method
    public void click(WebElement element) {
        waitForClickable(element);
        element.click();
    }

    // SendKeys method
    public void sendKeys(WebElement element, String value) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(value);
    }

    // Get text
    public String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    // Get page title
    public String getTitle() {
        return driver.getTitle();
    }
}