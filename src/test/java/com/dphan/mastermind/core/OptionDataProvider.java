package com.dphan.mastermind.core;

import com.tngtech.java.junit.dataprovider.DataProvider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OptionDataProvider {

    @DataProvider
    public static Object[][] allValidCases() {
        return new Object[][] {
                {"0", Option.CUSTOM},
                {"1", Option.AUTO_GENERATED}
        };
    }

}
