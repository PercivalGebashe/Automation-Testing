package io.github.PercivalGebashe.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
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

        String screenshot = baseTest.takeScreenshot(result.getName());
        test.fail(result.getThrowable()).log(
                Status.FAIL,
                MediaEntityBuilder.createScreenCaptureFromPath("test-output/screenshots/" + result.getName() +  ".png").build());
    }

    @Override
    public void onFinish(ITestContext context) {
        String projectDir = System.getProperty("user.dir");
        System.out.println("project dir:" + projectDir);
        extent.flush();
    }
}
