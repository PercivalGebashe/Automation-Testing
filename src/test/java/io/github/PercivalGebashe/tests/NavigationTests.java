package io.github.PercivalGebashe.tests;

import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.FactorialPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @Test(groups = {"navigation"})
    public void testAboutPage() { // TC-15
        FactorialPage fp = new FactorialPage(page);

        fp.clickAbout();
        Assert.assertTrue(page.url().contains("about"));
    }

    @Test(groups = {"navigation"})
    public void testTermsPage() { // TC-17
        FactorialPage fp = new FactorialPage(page);

        fp.clickTerms();
        Assert.assertTrue(page.content().contains("not yet ready"));
    }

    @Test(groups = {"navigation"})
    public void testPrivacyPage() { // TC-18
        FactorialPage fp = new FactorialPage(page);

        fp.clickPrivacy();
        Assert.assertTrue(page.content().contains("not yet ready"));
    }
}
