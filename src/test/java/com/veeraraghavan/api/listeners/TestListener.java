package com.veeraraghavan.api.listeners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started !!!!");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test Suite Finished !!!!");
    }

    public void onTestStart(ITestResult result) {
        logger.info("Test :::: {} Started", result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test :::: {} Passed", result.getMethod().getMethodName());
        logger.info("Test with description :::: {} Passed", result.getMethod().getDescription());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test :::: {} Failed", result.getMethod().getMethodName());
        logger.error("Test with description :::: {} Failed", result.getMethod().getDescription());
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("Test :::: {} Skipped", result.getMethod().getMethodName());
        logger.info("Test with description :::: {} Skipped", result.getMethod().getDescription());
    }
}
