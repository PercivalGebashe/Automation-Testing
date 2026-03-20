package io.github.PercivalGebashe.testData;

import org.testng.annotations.DataProvider;

public class ApiData {

    @DataProvider(name = "apiData")
    public Object[][] apiData() {
        return new Object[][]{
                {"5", "200", "\"answer\":120" },
                {"171", "200", "\"answer\":1241018070"},
                {"-1", "400", "\"error\": \"Invalid input: n must be a non-negative integer\""},
                {"abc", "400", "\"error\": \"Invalid input: n must be an integer.\""},
                {"", "400", "\"error\": \"Invalid input: n must be an integer.\""},
                {"992", "422", "\"error\": \"Invalid input: n is too large to process\""}
        };
    }

    @DataProvider(name = "apiRequestStructure")
    public Object[][] apiRequestStructure(){
        return new Object[][]{
                {"5", "/factorial", "POST", "number=5"}
        };
    }
}
