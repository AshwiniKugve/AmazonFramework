package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for clickable
    public void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Click method
    public void click(By locator) {
        waitForClickable(locator);
        driver.findElement(locator).click();
    }

    // SendKeys method
    public void sendKeys(By locator, String value) {
        waitForVisibility(locator);
        driver.findElement(locator).sendKeys(value);
    }

    // Get text (optional but useful)
    public String getText(By locator) {
        waitForVisibility(locator);
        return driver.findElement(locator).getText();
    }
}