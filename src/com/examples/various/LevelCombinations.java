package com.examples.various;

import java.util.HashSet;
import java.util.Set;

public class LevelCombinations {

    public static void main(String args[]) {

        String[][] levels = new String[][]{
                {"H", "D"},
                {"H", "N", "D"},
        };

        Set<Set<String>> result = visit(0, levels, new HashSet<>());
        for (Set<String> set : result) {
            System.out.print("[");
            for (String element : set) {
                System.out.print(element + ", ");
            }
            System.out.println("]");
        }

        assert result.size() == 5;
    }

    private static Set<Set<String>> visit(int level, String[][] levels, Set<String> currentResult) {

        Set<Set<String>> result = new HashSet<>();
        if (level == levels.length) {
            return result;
        }


        for (String element : levels[level]) {

            Set<String> newResult = new HashSet<>(currentResult);
            newResult.add(element);
            result.add(newResult);
            for (Set<String> intermediateResult : visit(level + 1, levels, newResult)) {
                result.add(intermediateResult);
            }
        }

        return result;
    }
}
