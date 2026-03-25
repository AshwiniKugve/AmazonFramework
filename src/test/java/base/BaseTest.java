package base;

import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class BaseTest {

    public static WebDriver driver;

    public void setup() {

        driver = DriverFactory.initDriver();
    }

    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}