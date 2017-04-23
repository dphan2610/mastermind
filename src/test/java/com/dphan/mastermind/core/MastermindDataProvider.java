package com.dphan.mastermind.core;

import com.dphan.mastermind.core.Pin;
import com.tngtech.java.junit.dataprovider.DataProvider;

import java.util.Arrays;
import java.util.List;
import static com.dphan.mastermind.core.Pin.BLACK;
import static com.dphan.mastermind.core.Pin.WHITE;

public class MastermindDataProvider {

    @DataProvider
    public static Object[][] essentialCases() {
        return new Object[][] {
                {solution(1), answer(1), black(1), white(0)},
                {solution(2), answer(2), black(1), white(0)},
                {solution(1, 2, 3), answer(1, 5, 5), black(1), white(0)},
                {solution(1, 2, 3), answer(1, 5, 6), black(1), white(0)},
                {solution(1, 2, 3), answer(4, 5, 1), black(0), white(1)},
                {solution(1, 2, 3), answer(4, 1, 1), black(0), white(1)},
                {solution(1, 2, 3), answer(1, 1, 1), black(1), white(0)},
                {solution(1, 2, 3), answer(2, 2, 4), black(1), white(0)},
                {solution(1, 2, 2), answer(2, 3, 3), black(0), white(1)},
                {solution(5, 5, 5), answer(5, 1, 2), black(1), white(0)},
                {solution(5, 5, 5), answer(1, 5, 2), black(1), white(0)},
                {solution(5, 5, 5), answer(1, 2, 5), black(1), white(0)},
                {solution(1, 2, 3), answer(1, 2, 8), black(2), white(0)},
                {solution(1, 2, 3), answer(1, 3, 2), black(1), white(2)},
                {solution(2, 6, 1, 1), answer(1, 2, 3, 4), black(0), white(2)},
                {solution(2, 6, 1, 1), answer(1, 3, 3, 4), black(0), white(1)},
                {solution(4, 6, 7, 1, 1), answer(1, 1, 1, 5, 0), black(0), white(2)},
        };
    }

    @DataProvider
    public static Object[][] emptyCases() {
        return new Object[][] {
                {solution(1), answer(2)},
                {solution(1, 2, 3), answer(4, 5, 6)},
                {solution(1, 1), answer(2, 2)},
                {solution(1, 2, 3, 2), answer(4, 4, 6, 7)},
        };
    }

    @DataProvider
    public static Object[][] invalidInput() {
        return new Object[][] {
                {solution(), answer(1)},
                {solution(1), answer()},
                {solution(), answer()},
                {solution(1), answer(1, 2)},
                {solution(1, 2), answer(5)},
                {solution(1, 2, 3, 4, 5), answer(4, 4, 1, 2)},
        };
    }

    @DataProvider
    public static Object[][] verifyParamsNotGetChangedCases() {
        return new Object[][] {
                {solution(1, 2, 3), answer(1, 2, 3)},
                {solution(1, 2, 3), answer(1, 1, 1)},
                {solution(1, 2, 3), answer(4, 5, 6)},
                {solution(1, 1, 2), answer(2, 1, 1)},
                {solution(1, 2, 3), answer(4, 5, 1)},
                {solution(2, 6, 1, 1), answer(1, 2, 3, 4)},
        };
    }

    private static <T> List<T> solution(T...ts) {
        return Arrays.asList(ts);
    }

    private static <T> List<T> answer(T...ts) {
        return Arrays.asList(ts);
    }

    private static int black(int count) {
        return count;
    }

    private static int white(int count) {
        return count;
    }
}
