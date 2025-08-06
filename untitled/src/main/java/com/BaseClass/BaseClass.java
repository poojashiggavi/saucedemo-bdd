package com.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;

    // This method loads config and launches browser with URL
    public void setupbrowser() {
        try {
            // Load properties file
            FileInputStream input = new FileInputStream("src/test/java/resources/Properties/Config.properties");
            prop = new Properties();
            prop.load(input);

            String browser = prop.getProperty("browser");
            String url = prop.getProperty("url");

            // Initialize the WebDriver based on browser value
            if (browser.equalsIgnoreCase("chrome")) {
                // Optionally set chromedriver path if needed
                // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                // Optionally set edgedriver path if needed
                // System.setProperty("webdriver.edge.driver", "path/to/edgedriver");
                driver = new EdgeDriver();
            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.manage().window().maximize();
            driver.get(url);

        } catch (IOException e) {
            System.out.println("Failed to load config file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Failed to launch browser: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Optional: cleanup method to close the browser
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
