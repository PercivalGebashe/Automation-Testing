package io.github.PercivalGebashe.tests;

import com.microsoft.playwright.TimeoutError;
import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.BasePage;
import io.github.PercivalGebashe.testData.BoundaryCasesData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoundaryTests extends BaseTest {

    @Test(dataProvider = "boundaryCases", dataProviderClass = BoundaryCasesData.class, groups = {"boundary"})
    public void testBoundaryBehaviour(String input, String expected) {
        BasePage fp = new BasePage(page);

        fp.submitNumber(input);

        String content = null;
        try {
            content = fp.getResultText();
        } catch (RuntimeException e) {
            assertTrue(false, e.getMessage());
        }
        System.out.println("Content: " + content);

        assertTrue(
            content.matches(expected + ".*"),
            String.format("Expected boundary behaviour not observed for input: %s.\nExpected %s but got %s",
                input,
                expected,
                content)
        );
    }
}
