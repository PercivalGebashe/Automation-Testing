package io.github.PercivalGebashe.tests;


import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.FactorialPage;
import io.github.PercivalGebashe.testData.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionalTests extends BaseTest {

    // TC-A1: Form validation styling
    @Test(groups = {"additional"}, dataProvider = "additionalValid", dataProviderClass = TestData.class)
    public void testValidationStyling(String input, String expected) {
        FactorialPage fp = new FactorialPage(page);

        fp.submitNumber(input);

        Assert.assertTrue(fp.isInputHighlighted(),
                "Input field is not highlighted for invalid input");

        Assert.assertTrue(fp.getErrorText().toLowerCase().contains(expected),
                "Validation message not displayed correctly");
    }

    // TC-A2: Factorial of 12
    @Test(groups = {"additional"}, dataProvider = "additionalValid", dataProviderClass = TestData.class)
    public void testFactorialOf12(String input, String expected) {
        FactorialPage fp = new FactorialPage(page);

        fp.submitNumber(input);

        String result = fp.getResultText();

        Assert.assertTrue(result.contains(expected),
                "Incorrect factorial result for " + input);
    }

    // TC-A3: API request verification
    @Test(groups = {"additional"})
    public void testApiRequestStructure() {
        final boolean[] requestCaptured = {false};

        page.onRequest(request -> {
            if (request.url().contains("/factorial")) {

                requestCaptured[0] = true;

                // Verify method
                Assert.assertEquals(request.method(), "POST",
                        "Incorrect HTTP method");

                // Verify payload
                String postData = request.postData();
                Assert.assertTrue(postData.contains("number=5"),
                        "Payload does not contain expected parameter");
            }
        });

        FactorialPage fp = new FactorialPage(page);

        fp.submitNumber("5");

        Assert.assertTrue(requestCaptured[0],
                "API request was not captured");
    }
}
