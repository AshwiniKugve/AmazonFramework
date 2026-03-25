package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver() {

        ConfigReader config = new ConfigReader();

        String browser = config.getProperty("browser");
        String url = config.getProperty("url");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }
}