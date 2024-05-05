package org.example;

import org.example.enums.Capability;
import org.example.listeners.ElementActionListener;
import org.example.listeners.TestListener;
import org.example.utils.DriverFactory;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void baseTestSetUp() {
        driver = DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementActionListener());
        driver = decorator.decorate(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void closeSession() {
        driver.quit();
    }
}
