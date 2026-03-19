package io.github.PercivalGebashe.tests;

import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.FactorialPage;
import io.github.PercivalGebashe.testData.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoundaryTests extends BaseTest {

    @Test(dataProvider = "boundaryCases", dataProviderClass = TestData.class, groups = {"boundary"})
    public void testBoundaryBehaviour(String input, String expected) {
        FactorialPage fp = new FactorialPage(page);

        fp.submitNumber(input);

        String content = page.content();

        Assert.assertTrue(content.contains(expected),
                "Expected boundary behaviour not observed for input: " + input);
    }
}
