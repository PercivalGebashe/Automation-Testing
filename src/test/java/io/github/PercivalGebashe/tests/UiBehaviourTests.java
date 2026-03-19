package io.github.PercivalGebashe.tests;

import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.FactorialPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UiBehaviourTests extends BaseTest {

    @Test(groups = {"ui"})
    public void testErrorMessageVisibility() { // TC-13
        FactorialPage fp = new FactorialPage(page);

        fp.submitNumber("5.5");

        Assert.assertTrue(fp.getErrorText().toLowerCase().contains("integer"));
        Assert.assertTrue(fp.isInputHighlighted());
    }

    @Test(groups = {"ui"})
    public void testCorrectionFlow() { // TC-14
        FactorialPage fp = new FactorialPage(page);

        fp.submitNumber("5.5");

        fp.submitNumber("5");

        Assert.assertTrue(fp.getResultText().contains("120"));
    }
}
