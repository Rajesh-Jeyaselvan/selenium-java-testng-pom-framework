package org.example.base;

import org.example.factory.DriverFactory;
import org.example.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        // 1) Start browser based on config
        DriverFactory.initDriver(ConfigReader.get("browser"));

        // 2) Open base URL
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        // Close browser after every test
        DriverFactory.quitDriver();
    }
}
