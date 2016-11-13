package com.examples.algorithms.sorting;

public class ShellSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] input) {

        // Generate the sequence
        int h = 1;
        while (h < input.length / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < input.length; i++) {
                for (int j = i; j >= h && less(input, j, j - h); j = j - h) {
                    swap(input, j - h, j);
                }
            }

            h = h / 3;
        }
    }
}
