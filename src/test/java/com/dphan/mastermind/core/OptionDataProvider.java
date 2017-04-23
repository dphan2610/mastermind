package com.dphan.mastermind.core;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class OptionDataProvider {

    @DataProvider
    public static Object[][] allValidCases() {
        return new Object[][] {
                {"0", Option.CUSTOM},
                {"1", Option.AUTO_GENERATED}
        };
    }

}
