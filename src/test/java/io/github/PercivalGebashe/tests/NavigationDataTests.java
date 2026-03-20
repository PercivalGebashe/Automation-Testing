package io.github.PercivalGebashe.tests;

import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.FactorialPage;
import io.github.PercivalGebashe.testData.NavigationData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationDataTests extends BaseTest {

    @Test(groups = {"navigation"}, dataProvider = "navigation", dataProviderClass = NavigationData.class)
    public void testPage(String link, String expected) { // TC-15
        FactorialPage fp = new FactorialPage(page);

        fp.navigateTo(link);
        Assert.assertTrue(page.url().contains(expected));
    }
}
