package io.github.PercivalGebashe.tests;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.FormData;
import com.microsoft.playwright.options.RequestOptions;
import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.testData.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests extends BaseTest {

    @Test(groups = {"api"})
    public void testApiValidFactorial() { // TC-18
        APIRequestContext request = playwright.request().newContext();

        APIResponse response = request.post(
                "https://qainterview.pythonanywhere.com/factorial",
                RequestOptions.create()
                        .setForm(FormData.create()
                                .append("number", "5"))
        );

        Assert.assertEquals(response.status(), 200);
        Assert.assertTrue(response.text().contains("120"));
    }

    @Test(groups = {"api"}, dataProvider = "apiInvalid", dataProviderClass = TestData.class)
    public void testApiLargeNumber(String input) {
        APIRequestContext request = playwright.request().newContext();

        APIResponse response = request.post(
                "https://qainterview.pythonanywhere.com/factorial",
                RequestOptions.create()
                        .setForm(FormData.create().append("number", input))
        );

        Assert.assertEquals(response.status(), input);
        Assert.assertTrue(response.text().contains("1241018070"));
    }

    @Test(dataProvider = "apiInvalid", dataProviderClass = TestData.class, groups = {"api"})
    public void testApiInvalidInputs(String input) {
        APIRequestContext request = playwright.request().newContext();

        APIResponse response = request.post(
                "https://qainterview.pythonanywhere.com/factorial",
                RequestOptions.create()
                        .setForm(FormData.create().append("number", input))
        );

        Assert.assertTrue(response.status() >= 500,
                "Expected server error for input: " + input);
    }
}
