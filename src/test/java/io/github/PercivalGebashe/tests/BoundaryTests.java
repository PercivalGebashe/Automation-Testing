package io.github.PercivalGebashe.tests;

import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.BasePage;
import io.github.PercivalGebashe.testData.BoundaryCasesData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoundaryTests extends BaseTest {

    @Test(dataProvider = "boundaryCases", dataProviderClass = BoundaryCasesData.class, groups = {"boundary"})
    public void testBoundaryBehaviour(String input, String expected) {
        BasePage fp = new BasePage(page);

        fp.submitNumber(input);

        String content =fp.getResultText();
        System.out.println("Content: " + content);

        Assert.assertTrue(
                content.matches(expected + ".*"),
                "Expected boundary behaviour not observed for input: " + input);
    }
}
