package io.github.PercivalGebashe.testData;

import org.testng.annotations.DataProvider;

public class UiData {

    @DataProvider(name = "uiCorrectionFlowData")
    public Object[][] uiValid(){
        return new Object[][]{
                {"5.5", "5", "The factorial of 5 is: 120"}
        };
    }

    @DataProvider(name = "uiMessageData")
    public Object[][] uiMessageData(){
        return new Object[][]{
                {"5.5", "Please enter an integer"}
        };
    }
}
