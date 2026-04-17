package io.github.PercivalGebashe.base;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenshotType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

public class BaseTest {
    protected static final String BASE_URL = "http://qainterview.pythonanywhere.com";
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    @BeforeMethod(groups = {"setup"})
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium()
            .launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions()
            .setBaseURL(BASE_URL));
        page = browserContext.newPage();
        page.setDefaultTimeout(10000);
        page.navigate("./");
    }

    @AfterMethod(groups = {"tearDown"})
    public void tearDown() {
        browser.close();
        playwright.close();
    }


    public String takeScreenshotToFile(String testName) {

        Path screenshotsDir = Paths.get(System.getProperty("user.dir"),"test-output", "screenshots");
        new File(screenshotsDir.toUri()).mkdirs();

        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        Path imagePath =  Paths.get(screenshotsDir.toString(), (testName + "_" + timestamp +  ".png"));

        byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
            .setPath(imagePath)
            .setType(ScreenshotType.PNG)
            .setFullPage(true));
        return imagePath.toString();
    }

    public String takeScreenshotBase64(String imagePath) {
        File file = new File(imagePath);
        byte[] fileContent = null;
        try {
            fileContent = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Base64.getEncoder().encodeToString(fileContent);
    }
}