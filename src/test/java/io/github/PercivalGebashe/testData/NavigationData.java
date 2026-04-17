package io.github.PercivalGebashe.testData;

import org.testng.annotations.DataProvider;

public class NavigationData {

    @DataProvider(name = "navigation")
    public Object[][] navigation() {
        return new Object[][]{
                {"about", "/about"},
                {"terms", "/terms",},
                {"privacy", "/privacy"}
        };
    }
}
