package com.examples.sorting;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] input) {

        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0 && less(input, j, j - 1) ; j--) {
                swap(input, j - 1, j);
            }
        }
    }
}
