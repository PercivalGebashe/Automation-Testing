package io.github.PercivalGebashe.tests;

import io.github.PercivalGebashe.base.BaseTest;
import io.github.PercivalGebashe.pages.AboutPage;
import io.github.PercivalGebashe.pages.BasePage;
import io.github.PercivalGebashe.pages.PrivacyPage;
import io.github.PercivalGebashe.pages.TermsAndConditionsPage;
import io.github.PercivalGebashe.testData.NavigationData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.function.Function;

import static org.testng.Assert.assertTrue;

public class NavigationDataTests extends BaseTest {

    @Test(groups = {"navigation"}, dataProvider = "navigation", dataProviderClass = NavigationData.class)
    public void testPage(String link, String expected) { // TC-15
        BasePage fp = new BasePage(page);
        fp.navigateTo(link);

        var openedPage = switch (link.toLowerCase()){
            case "about" ->  new AboutPage(page);
            case "privacy" -> new PrivacyPage(page);
            case "terms" -> new TermsAndConditionsPage(page);

            default -> throw new IllegalStateException("Unexpected value: " + link.toLowerCase());
        };

        String actual = openedPage.getCurrentUrl();

        assertTrue(actual.contains(expected),
        "Expected result to contain: " + expected + " but got: " + actual);
        assertTrue(openedPage.isLoaded(), String.format("%s not loaded", toTitleCase.apply(link)));
    }

    private Function<String, String> toTitleCase = s ->
            (s == null || s.isEmpty()) ? s :
                    Character.toTitleCase(s.charAt(0)) + s.substring(1).toLowerCase();
}
