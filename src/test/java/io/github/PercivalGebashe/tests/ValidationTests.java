package io.github.PercivalGebashe.tests;

import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.BasePage;
import io.github.PercivalGebashe.testData.ValidFactorialsData;
import io.github.PercivalGebashe.testData.InvalidInputsData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationTests extends BaseTest {

    @Test(dataProvider = "validFactorials", dataProviderClass = ValidFactorialsData.class, groups = {"functional"})
    public void testValidFactorials(String input, String expected) {
        BasePage fp = new BasePage(page);

        fp.submitNumber(input);

        String result = fp.getResultText();

        Assert.assertTrue(result.matches(expected + ".*"),
                "Expected result to contain: " + expected + " but got: " + result);
    }

    @Test(dataProvider = "invalidInputs", dataProviderClass = InvalidInputsData.class, groups = {"validation"})
    public void testInvalidInputs(String input, String expected) {
        BasePage fp = new BasePage(page);

        fp.submitNumber(input);

        String content = page.content();

        Assert.assertTrue(content.toLowerCase().contains(expected.toLowerCase()),
                "Validation failed for input: " + input);
    }
}
