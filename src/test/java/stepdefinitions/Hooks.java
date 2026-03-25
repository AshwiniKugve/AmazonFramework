package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import base.BaseTest;
import utils.ScreenshotUtil;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks extends BaseTest {

    @Before
    public void start() {
        setup();
    }

    @After
    public void end(Scenario scenario) {

        if (scenario.isFailed()) {

            String path = ScreenshotUtil.captureScreenshot(driver, scenario.getName());

            try {
                byte[] file = Files.readAllBytes(Paths.get(path));
                scenario.attach(file, "image/png", scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        tearDown();
    }
}