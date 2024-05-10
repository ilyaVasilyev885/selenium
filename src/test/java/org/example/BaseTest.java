package org.example;

import org.example.listeners.TestListener;
import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void baseTestSetUp() {
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void closeSession() {
        DriverManager.quitDriver();
    }
}
