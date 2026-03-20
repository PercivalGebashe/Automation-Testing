package io.github.PercivalGebashe.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/index.html");
            reporter.config().setDocumentTitle("Automation Report");
            reporter.config().setReportName("Factorial Test Results");
            extent.attachReporter(reporter);


        }
        return extent;
    }


}
