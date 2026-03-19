package io.github.PercivalGebashe.tests;

import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.FactorialPage;
import io.github.PercivalGebashe.testData.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationTests extends BaseTest {

    @Test(dataProvider = "validFactorials", groups = {"functional"})
    public void testValidFactorials(String input, String expected) {
        FactorialPage fp = new FactorialPage(page);

        fp.submitNumber(input);

        String result = fp.getResultText();

        Assert.assertTrue(result.contains(expected),
                "Expected result to contain: " + expected + " but got: " + result);
    }

    @Test(dataProvider = "invalidInputs", dataProviderClass = TestData.class, groups = {"validation"})
    public void testInvalidInputs(String input, String expected) {
        System.out.println(expected);
        FactorialPage fp = new FactorialPage(page);

        fp.submitNumber(input);

        String content = page.content();
        System.out.println(content);

        Assert.assertTrue(content.toLowerCase().contains(expected.toLowerCase()),
                "Validation failed for input: " + input);
    }
}
