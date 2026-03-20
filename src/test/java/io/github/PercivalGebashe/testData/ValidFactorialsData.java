package io.github.PercivalGebashe.testData;

import org.testng.annotations.DataProvider;

public class ValidFactorialsData {

    @DataProvider(name = "validFactorials")
    public Object[][] validFactorials() {
        return new Object[][]{
                {"5", "The factorial of 5 is: 120"},     // TC-01
                {"0", "The factorial of 0 is: 1"},       // TC-02
                {"1", "The factorial of 1 is: 1"},       // TC-03
                {"170", "The factorial of 170 is: 7.257"},  // TC-04 (partial match due to long number)
                {"12", "The factorial of 12 is: 479001600"}
        };
    }
}
