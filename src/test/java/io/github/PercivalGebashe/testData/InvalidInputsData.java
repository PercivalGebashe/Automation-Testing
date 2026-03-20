package io.github.PercivalGebashe.testData;

import org.testng.annotations.DataProvider;

public class InvalidInputsData {

    @DataProvider(name = "invalidInputs")
    public Object[][] invalidInputs() {
        return new Object[][]{
                {"-1", "Please enter a positive integer"},     // TC-07
                {"5.5", "Please enter an integer"},     // TC-08
                {"", "Please enter an integer"},          // TC-09
                {" ", "Please enter an integer"},         // TC-10
                {"5abc", "Please enter an integer"},    // TC-11
                {"@5", "Please enter an integer"}       // TC-12
        };
    }
}
