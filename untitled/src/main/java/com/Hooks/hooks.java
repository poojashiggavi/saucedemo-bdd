package com.Hooks;

import com.BaseClass.BaseClass;
import com.Constants.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.BaseClass.BaseClass;
import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static java.lang.Byte.BYTES;

public class hooks extends BaseClass {


    @Before
    public void setUp(Scenario scenario) throws IOException {
        System.out.println("Starting scenario: " + scenario.getName());
        setupbrowser();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", scenario.getName().replaceAll(" ", "_"));
        }

        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Browser closed successfully.");
        } else {
            System.out.println("Driver was null, nothing to close.");
        }

        System.out.println("After hook finished for: " + scenario.getName());
    }


}
