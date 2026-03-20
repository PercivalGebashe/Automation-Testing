package io.github.PercivalGebashe.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
        test.fail(result.getThrowable());

        Object currentClass = result.getInstance();

        BaseTest baseTest = (BaseTest) currentClass;

        String screenshotPath = baseTest.takeScreenshot(result.getName());

        test.addScreenCaptureFromBase64String(screenshotPath, result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        String projectDir = System.getProperty("user.dir");
        System.out.println("project dir:" + projectDir);
//        ExtentPDFCucumberReporter pdf = new ExtentPDFCucumberReporter("\\reports\\index.html", "reports\\ExtentPDFReport.pdf");
//
//        extent.attachReporter(pdf);
        extent.flush();
    }
}
