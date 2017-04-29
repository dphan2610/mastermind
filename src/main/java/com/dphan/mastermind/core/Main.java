package com.dphan.mastermind.core;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

import static com.dphan.mastermind.core.Option.AUTO_GENERATED;
import static com.dphan.mastermind.core.Option.CUSTOM;
import static com.dphan.mastermind.core.Pin.BLACK;
import static com.dphan.mastermind.core.Pin.WHITE;

public class Main {

    private static final List<String> NUMBER_LIST_MASTER = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    private static final Set<String> NUMBER_SET_MASTER = new HashSet<String>(NUMBER_LIST_MASTER);

    public static void main(String[] args) {
        println("Welcome to Mastermind CLI 1.0");
        int problemSize = getProblemSizeFromUser();

        Option option = getOptionFromUser();
        List<String> solution = getSequence(option, problemSize);

        println("Solution: " + Arrays.toString(solution.toArray()));
        mainGameLoop(problemSize, solution);
    }

    private static void mainGameLoop(int problemSize, List<String> solution) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            print("Enter guess sequence: ");
            String input = scanner.nextLine();

            try {
                List<String> inputGuesses = getInputSequenceList(input, NUMBER_LIST_MASTER, problemSize);
                println("Your guess: " + Arrays.toString(inputGuesses.toArray()));

                if (inputGuesses.equals(solution)) {
                    println("Congratulations, you win!");
                    break;
                }

                List<Pin> resultPins = Mastermind.getPins(solution, inputGuesses);
                println("Pin: " + pinListToString(resultPins));
                println("");

            } catch (IllegalArgumentException iae) {
                println(iae.getMessage());
            }
        }
    }

    private static String getCodeMaster() {
        Scanner scanner = new Scanner(System.in);
        print("Enter your name: ");
        return scanner.nextLine();
    }

    private static Option getOptionFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            print("Enter 0 for custom sequence, 1 for auto-generated: ");
            String optionInput = scanner.nextLine();
            if (optionInput.equals("0") || optionInput.equals("1")) {
                return Option.fromString(optionInput);
            }
            println("Your entry is invalid. Valid inputs are 0 or 1. Please try again.");
        }
    }

    private static List<String> getSequence(Option option, int size) {
        if (option == AUTO_GENERATED) {
            return SolutionGenerator.random(NUMBER_SET_MASTER, size);
        }
        if (option == CUSTOM) {
            return getCustomSequence(size);
        }
        throw new NotImplementedException();
    }

    private static List<String> getCustomSequence(int size) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            print("Enter your sequence: ");
            String input = scanner.nextLine();
            try {
                return getInputSequenceList(input, NUMBER_LIST_MASTER, size);
            } catch (IllegalArgumentException iae) {
                println(iae.getMessage());
            }
        }
    }

    private static List<String> getInputSequenceList(String inputSequence, List<String> masterList, int allowedInputSize) {
        List<String> sequenceList = Arrays.asList(inputSequence.split(" "));
        InputValidator.validateSequence(sequenceList, masterList, allowedInputSize);
        return sequenceList;
    }

    private static String pinListToString(List<Pin> pins) {
        int numBlack = 0;
        int numWhite = 0;

        for (Pin pin : pins) {
            if (pin == BLACK) {
                numBlack++;
            } else if (pin == WHITE) {
                numWhite++;
            }
        }
        return String.format("%d P, %d C", numBlack, numWhite);
    }

    private static int getProblemSizeFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            print("Enter size: ");
            String inputSize = scanner.nextLine();
            try {
                InputValidator.validateSize(inputSize);
            } catch (IllegalArgumentException iae) {
                println(iae.getMessage());
                continue;
            }
            return Integer.parseInt(inputSize);
        }
    }

    private static void print(String text) {
        System.out.print(text);
    }
    private static void println(String text) {
        System.out.println(text);
    }

}
