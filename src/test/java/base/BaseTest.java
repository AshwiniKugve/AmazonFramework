package base;

import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class BaseTest {

    public static WebDriver driver;

    public void setup() {

        driver = DriverFactory.initDriver();
    }

   /* public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
   zA	QW}*/
}
/*package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setup() {
        driver.set(new ChromeDriver());
    }

    protected static WebDriver getDriver() {
        return driver.get();
    }

    //public void tearDown() {
      //  driver.get().quit();
    //}
}*/