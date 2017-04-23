package com.dphan.mastermind.core;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.dphan.mastermind.core.Pin.BLACK;
import static com.dphan.mastermind.core.Pin.WHITE;
import static java.util.Collections.frequency;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(DataProviderRunner.class)
public class SolutionGeneratorTest {

    @Test
    @UseDataProvider(value = "verifySizeCases", location = SolutionGenDataProvider.class)
    public void testRandom_VerifySize(Set<Number> numberSet, int expectedSize) {
        List<Number> result = SolutionGenerator.random(numberSet, expectedSize);
        assertThat(result.size(), is(expectedSize));
    }
}
