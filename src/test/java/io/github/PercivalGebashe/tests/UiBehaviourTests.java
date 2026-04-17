package io.github.PercivalGebashe.tests;

import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.BasePage;
import io.github.PercivalGebashe.testData.UiData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UiBehaviourTests extends BaseTest {

    @Test(groups = {"ui"}, dataProvider = "uiMessageData", dataProviderClass = UiData.class)
    public void testErrorMessageVisibility(String input, String expected) {
        BasePage fp = new BasePage(page);

        fp.submitNumber(input);

        assertThat(fp.getResultTextLocator()).containsText(expected);

        Assert.assertEquals(fp.getResultText(), expected);
        Assert.assertTrue(fp.isInputHighlighted());
    }

    @Test(groups = {"ui"}, dataProvider = "uiCorrectionFlowData", dataProviderClass = UiData.class)
    public void testCorrectionFlow(String invalidInput, String expectedWarning, String validInput, String expectedMsg) {
        BasePage fp = new BasePage(page);

        fp.submitNumber(invalidInput);

        assertThat(fp.getResultTextLocator()).containsText(expectedWarning);
        Assert.assertEquals(fp.getResultText(),expectedWarning);

        fp.submitNumber(validInput);

        assertThat(fp.getResultTextLocator()).containsText(expectedMsg);
        Assert.assertEquals(fp.getResultText(),expectedMsg);
    }
}
