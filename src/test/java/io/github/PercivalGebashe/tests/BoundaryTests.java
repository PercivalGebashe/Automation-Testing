package io.github.PercivalGebashe.tests;

import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.FactorialPage;
import io.github.PercivalGebashe.testData.BoundaryCasesData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoundaryTests extends BaseTest {

    @Test(dataProvider = "boundaryCases", dataProviderClass = BoundaryCasesData.class, groups = {"boundary"})
    public void testBoundaryBehaviour(String input, String expected) {
        FactorialPage fp = new FactorialPage(page);

        fp.submitNumber(input);

        String content = page.content();

        Assert.assertEquals(
                content,
                expected,
                "Expected boundary behaviour not observed for input: " + input);
    }
}
