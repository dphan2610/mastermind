package com.dphan.mastermind.core;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Mastermind {

    public static <T> List<Pin> getPins(List<T> solutions, List<T> answers) {
        validate(solutions, answers);

        List<Pin> pins = new LinkedList<Pin>();
        List<T> solutionsClone = getDeepCopy(solutions);
        List<T> answersClone = getDeepCopy(answers);

        // Find blacks
        for (int i = 0; i < answersClone.size(); i++) {
            T answer = answersClone.get(i);
            if (answer.equals(solutionsClone.get(i))) {
                solutionsClone.set(i, null);
                answersClone.set(i, null);
                pins.add(Pin.BLACK);
            }
        }

        // Find whites
        for (int i = 0; i < answersClone.size(); i++) {
            T answer = answersClone.get(i);
            if (answer == null) {
                continue;
            }
            for (int k = 0; k < solutionsClone.size(); k++) {
                if (answer.equals(solutionsClone.get(k))) {
                    solutionsClone.set(k, null);
                    answersClone.set(i, null);
                    pins.add(Pin.WHITE);
                    break;
                }
            }
        }
        return pins;
    }

    private static <T> void validate(List<T> solutions, List<T> answers) {
        if (CollectionUtils.isEmpty(solutions)) {
            throw new IllegalArgumentException("Solution list cannot be empty.");
        }
        if (CollectionUtils.isEmpty(answers)) {
            throw new IllegalArgumentException("Answer list cannot be empty.");
        }
        if (solutions.size() != answers.size()) {
            throw new IllegalArgumentException("Answer list size must be equal to solution list size");
        }
    }

    private static <T> List<T> getDeepCopy(List<T> list) {
        List<T> newList = new ArrayList<T>();
        newList.addAll(list);
        return newList;
    }
}
