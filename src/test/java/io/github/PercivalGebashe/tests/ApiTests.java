package io.github.PercivalGebashe.tests;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.FormData;
import com.microsoft.playwright.options.RequestOptions;
import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.FactorialPage;
import io.github.PercivalGebashe.testData.ApiData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests extends BaseTest {

    @Test(groups = {"api"}, dataProvider = "apiData", dataProviderClass = ApiData.class)
    public void testApiInputValidation(String input, String expectedResponseCode, String expectedResponseBody) {
        APIRequestContext request = playwright.request().newContext();

        APIResponse response = request.post(
                "https://qainterview.pythonanywhere.com/factorial",
                RequestOptions.create()
                        .setForm(FormData.create()
                                .append("number", input))
        );

        Assert.assertEquals(response.status(), Integer.parseInt(expectedResponseCode));
        Assert.assertTrue(response.text().contains(expectedResponseBody));
    }

    @Test(groups = {"api"}, dataProvider = "apiRequestStructure", dataProviderClass = ApiData.class)
    public void testApiRequestStructure(String input, String expectedInURL, String expectedMethod, String expectedPayload) {
        final boolean[] requestCaptured = {false};

        page.onRequest(request -> {
            if (request.url().contains(expectedInURL)) {

                requestCaptured[0] = true;

                // Verify method
                Assert.assertEquals(request.method(), expectedMethod,
                        "Incorrect HTTP method");

                // Verify payload
                String postData = request.postData();
                Assert.assertTrue(postData.contains(expectedPayload),
                        "Payload does not contain expected parameter");
            }
        });

        FactorialPage fp = new FactorialPage(page);

        fp.submitNumber(input);

        Assert.assertTrue(requestCaptured[0],
                "API request was not captured");
    }
}
