package io.github.PercivalGebashe.base;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenshotType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.nio.file.Paths;
import java.util.Base64;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod(groups = {"setup"})
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        page.navigate("http://qainterview.pythonanywhere.com");
    }

    @AfterMethod(groups = {"tearDown"})
    public void tearDown() {
        browser.close();
        playwright.close();
    }


    public String takeScreenshot(String testName) {
        String dir = "test-output/screenshots/";
        new File(dir).mkdirs();

        String path = dir + testName + ".png";

        byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(path))
                .setType(ScreenshotType.PNG)
                .setFullPage(true));

        return Base64.getEncoder().encodeToString(screenshot);
    }
}