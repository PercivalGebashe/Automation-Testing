package io.github.PercivalGebashe.testData;

import org.testng.annotations.DataProvider;

public class BoundaryCasesData {

    @DataProvider(name = "boundaryCases")
    public Object[][] boundaryCases() {
        return new Object[][]{
                {"171", "The factorial of 171 is: [\\d.]+(?:e[+\\-]?\\d+)?"},  // TC-05
                {"992", "Input value is too large to process"}   // TC-06
        };
    }
}
