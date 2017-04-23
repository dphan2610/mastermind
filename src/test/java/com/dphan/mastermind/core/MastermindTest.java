package com.dphan.mastermind.core;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dphan.mastermind.core.Pin.BLACK;
import static com.dphan.mastermind.core.Pin.WHITE;
import static java.util.Collections.frequency;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class MastermindTest {

    @Test
    @UseDataProvider(value = "essentialCases", location = MastermindDataProvider.class)
    public void testGetPins_AtLeastOneMatch(List<Object> solution, List<Object> answer, int expectedBlackPins, int expectedWhitePins) {
        List<Pin> pins = Mastermind.getPins(solution, answer);
        assertThat(frequency(pins, BLACK), is(expectedBlackPins));
        assertThat(frequency(pins, WHITE), is(expectedWhitePins));
    }

    @Test
    @UseDataProvider(value = "emptyCases", location = MastermindDataProvider.class)
    public void testGetPins_NoMatch(List<Object> solution, List<Object> answer) {
        List<Pin> pins = Mastermind.getPins(solution, answer);
        assertTrue(pins.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    @UseDataProvider(value = "invalidInput", location = MastermindDataProvider.class)
    public void testGetPins_InvalidInput(List<Object> solution, List<Object> answer) {
        Mastermind.getPins(solution, answer);
    }

    @Test
    @UseDataProvider(value = "verifyParamsNotGetChangedCases", location = MastermindDataProvider.class)
    public void testGetPins_VerifyParametersNotAltered(List<Object> solution, List<Object> answer) {
        List<Object> solutionCopy = new ArrayList<Object>();
        solutionCopy.addAll(solution);

        Mastermind.getPins(solution, answer);
        assertThat(solution, is(solutionCopy));
    }
}
