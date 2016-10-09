package com.examples.sorting;

import java.util.Arrays;

public class SortingTest {

    public static void main(String[] args) {

        Integer[] testInput = createTestInput1();
        assert !isSorted(testInput);

        Arrays.sort(testInput);
        assert isSorted(testInput);

        testSortAlgorithm(new SelectionSort<>());
        testSortAlgorithm(new InsertionSort<>());

        System.out.println("All ok");
    }

    private static void testSortAlgorithm(Sort<Integer> sort) {
        testSortAlgorithmOnInput(sort, createTestInput1());
        testSortAlgorithmOnInput(sort, createTestInput2());
        testSortAlgorithmOnInput(sort, createTestInput3());
        testSortAlgorithmOnInput(sort, createTestInput4());
        testSortAlgorithmOnInput(sort, createTestInput5());
    }

    private static void testSortAlgorithmOnInput(Sort<Integer> sort, Integer[] input) {
        sort.sort(input);
        assert isSorted(input);
    }

    private static Integer[] createTestInput1() {
        return new Integer[]{2, 2, 4, 5, 1, 7, 3, 10};
    }

    private static Integer[] createTestInput2() {
        return new Integer[]{2, 2, 4, 5, 9, 1, 7, 3, 10};
    }

    private static Integer[] createTestInput3() {
        return new Integer[]{2, 2, 2, 2, 2, 2, 2, 2};
    }

    private static Integer[] createTestInput4() {
        return new Integer[]{2};
    }

    private static Integer[] createTestInput5() {
        return new Integer[]{};
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
