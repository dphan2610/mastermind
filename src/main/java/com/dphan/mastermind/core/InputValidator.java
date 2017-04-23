package com.dphan.mastermind.core;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    // TODO: Add tests
    public static void validateSequence(List<String> inputList, List<String> masterList, int allowedInputSize) {
        if (!masterList.containsAll(inputList)) {
            throw new IllegalArgumentException("Each element must be in the following set: " + Arrays.toString(masterList.toArray()));
        }
        if (inputList.size() != allowedInputSize) {
            throw new IllegalArgumentException("You must enter exactly " + allowedInputSize + " elements.");
        }
    }

    // TODO: Add tests
    public static void validateSize(String inputSize) {
        String errorMessage = "You must enter a number between 4 and 16.";
        try {
            int inputSizeNumber = Integer.parseInt(inputSize.trim());
            if (inputSizeNumber < 4 || inputSizeNumber > 16) {
                throw new IllegalArgumentException(errorMessage);
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
