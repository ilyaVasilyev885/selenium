package org.example.listeners;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.debug("Test " + result.getMethod().getMethodName() +  " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.debug("Test " + result.getMethod().getMethodName() +  " success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("Test " + result.getMethod().getMethodName() +  " failed");
    }
}
