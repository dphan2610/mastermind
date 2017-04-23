package com.dphan.mastermind.core;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Set;

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
