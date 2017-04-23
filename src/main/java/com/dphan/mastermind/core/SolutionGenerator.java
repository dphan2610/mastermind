package com.dphan.mastermind.core;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SolutionGenerator {

    public static <T> List<T> random(Set<T> objectSet, int size) {
        List<T> objectList = new ArrayList<T>();
        objectList.addAll(objectSet);

        List<T> solution = new ArrayList<T>(size);
        for (int i = 0; i < size; i++) {
            int selectIndex = random(0, objectList.size() - 1);
            solution.add(objectList.get(selectIndex));
        }
        return solution;
    }

    private static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
