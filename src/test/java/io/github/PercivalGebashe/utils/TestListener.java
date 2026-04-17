package io.github.PercivalGebashe.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.github.PercivalGebashe.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        BaseTest baseTest = (BaseTest) currentClass;

        String screenshotPath= baseTest.takeScreenshotToFile(result.getName());
        String base64String = baseTest.takeScreenshotBase64(screenshotPath);

        test.fail(result.getThrowable().getMessage());
        test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64String).build());
        test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
