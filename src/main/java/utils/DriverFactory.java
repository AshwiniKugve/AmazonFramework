package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // Thread-safe driver (important for parallel execution)
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Initialize driver
    public WebDriver initDriver() {

        ConfigReader config = new ConfigReader();

        String browser = config.getProperty("browser");
        String url = config.getProperty("url");

        if (browser.equalsIgnoreCase("chrome")) {
            tlDriver.set(new ChromeDriver());
        }
        // You can extend for other browsers later
        // else if (browser.equalsIgnoreCase("edge")) { ... }

        getDriver().manage().window().maximize();
        getDriver().get(url);

        return getDriver();
    }

    // Get driver (used everywhere)
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // Quit driver
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}