package com.examples.algorithms.sorting;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    public void sort(T[] input) {

        for (int i = 0; i < input.length; i++) {

            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (less(input, j, minIndex)) {
                    minIndex = j;
                }
            }
            swap(input, i, minIndex);
        }
    }
}
