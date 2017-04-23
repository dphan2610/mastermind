package com.dphan.mastermind.core;

import com.tngtech.java.junit.dataprovider.DataProvider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionGenDataProvider {

    @DataProvider
    public static Object[][] verifySizeCases() {
        return new Object[][] {
                {getSet(Arrays.asList(0)), 1},
                {getSet(Arrays.asList(0)), 2},
                {getSet(Arrays.asList(1)), 1},
                {getSet(Arrays.asList(1, 1)), 1},
                {getSet(Arrays.asList(1, 2)), 2},
                {getSet(Arrays.asList(5, 3, 1, 2, 4)), 1},
                {getSet(Arrays.asList(5, 3, 1, 2, 4)), 2},
                {getSet(Arrays.asList(5, 3, 1, 2, 4)), 5},
                {getSet(Arrays.asList(5, 3, 1, 2, 4)), 6},
                {getSet(Arrays.asList(5, 3, 1, 2, 4)), 7},
                {getSet(Arrays.asList(5, 3, 1, 2, 4)), 20}
        };
    }

    private static Set<Number> getSet(List<Integer> numberList) {
        Set<Number> numberSet = new HashSet<Number>();
        numberSet.addAll(numberList);
        return numberSet;
    }
}
