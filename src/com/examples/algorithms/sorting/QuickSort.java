package com.examples.algorithms.sorting;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] input) {
        Knuth.shuffle(input);
        sort(input, 0, input.length - 1);
    }

    private void sort(T[] input, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int pivot = partition(input, lo, hi);
        sort(input, lo, pivot - 1);
        sort(input, pivot + 1, hi);
    }

    private int partition(T[] input, int lo, int hi) {

        int i = lo; //Actually starts from lo + 1
        int j = hi + 1; //Actually starts from hi
        while (i < j) {
            while (less(input, ++i, lo)) if (i == hi) break; //Pre-increment to stay on the right index
            while (less(input, lo, --j)) if (j == lo) break; //Pre-increment to stay on the right index

            if (i < j) {
                swap(input, i, j);
            }
        }

        swap(input, lo, j);

        return j;
    }
}
