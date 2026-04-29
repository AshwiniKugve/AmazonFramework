package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utils.DriverFactory;
import utils.ScreenshotUtil;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {

    DriverFactory df = new DriverFactory();

    @Before
    public void start() {
        df.initDriver();   // ✅ start browser
    }

    @After
    public void end(Scenario scenario) {

        if (scenario.isFailed()) {

            String path = ScreenshotUtil.captureScreenshot(
                    DriverFactory.getDriver(), 
                    scenario.getName()
            );

            try {
                byte[] file = Files.readAllBytes(Paths.get(path));
                scenario.attach(file, "image/png", scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        DriverFactory.quitDriver();   // ✅ close browser (VERY IMPORTANT)
    }
}