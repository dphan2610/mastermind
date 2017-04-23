package com.dphan.mastermind.core;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(DataProviderRunner.class)
public class OptionTest {

    @Test
    @UseDataProvider(value = "allValidCases", location = OptionDataProvider.class)
    public void testFromString_AllValidValues(String code, Option expectedOption) {
        assertThat(Option.fromString(code), is(expectedOption));
    }
}
