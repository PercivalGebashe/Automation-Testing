package io.github.PercivalGebashe.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import tech.grasshopper.reporter.ExtentPDFReporter;

import java.io.File;
import java.io.IOException;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports();

            ExtentPDFReporter pdf = new ExtentPDFReporter("reports/extent-report.pdf");
            try {
                pdf.loadJSONConfig(new File("src/test/resources/pdf-config.json"));
            } catch (IOException e) {
                throw new RuntimeException("PDF Config loading error: ", e);
            }

            ExtentSparkReporter spark = new ExtentSparkReporter("reports/extent-report.html");
            try {
                spark.loadXMLConfig("src/test/resources/extent-config.xml");
            } catch (IOException e) {
                throw new RuntimeException("HTML Config loading error: ", e);
            }
            extent.attachReporter(spark, pdf);

        }
        return extent;
    }
}
