package io.github.PercivalGebashe.base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
}