package com.examples.sorting;

import java.util.Arrays;

public class SortingTest {

    public static void main(String[] args) {

        Integer[] testInput = createTestInput();
        assert !isSorted(testInput);

        Arrays.sort(testInput);
        assert isSorted(testInput);

        testSortAlgorithm(new SelectionSort<>());

        System.out.println("All ok");
    }

    private static void testSortAlgorithm(Sort<Integer> sort) {
        Integer[] input = createTestInput();
        sort.sort(input);
        assert isSorted(input);
    }

    private static Integer[] createTestInput() {
        return new Integer[]{2, 2, 4, 5, 1, 7, 3, 10};
    }

    private static boolean isSorted(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
