package io.github.PercivalGebashe.testData;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "additionalValid")
    public Object[][] validAdditional() {
        return new Object[][]{
                {"12", "The factorial of 12 is: 479001600"}
        };
    }

    @DataProvider(name = "additionalInvalid")
    public Object[][] invalidAdditional() {
        return new Object[][]{
                {"5.5", "Please enter an integer"}
        };
    }

    @DataProvider(name = "validFactorials")
    public Object[][] validFactorials() {
        return new Object[][]{
                {"5", "The factorial of 5 is: 120"},     // TC-01
                {"0", "The factorial of 5 is: 1"},       // TC-02
                {"1", "The factorial of 5 is: 1"},       // TC-03
                {"170", "The factorial of 5 is: 17.257"}  // TC-04 (partial match due to long number)
        };
    }

    @DataProvider(name = "boundaryCases")
    public Object[][] boundaryCases() {
        return new Object[][]{
                {"171", "Please enter an integer less than"},  // TC-05
                {"992", "Please enter an integer less than"}   // TC-06
        };
    }

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

    @DataProvider(name = "apiInvalid")
    public Object[][] apiInvalid() {
        return new Object[][]{
                {"171"},  //TC-19
                {"-1"},   // TC-21
                {"abc"},  // TC-22
                {""}      // TC-23
        };
    }


}
