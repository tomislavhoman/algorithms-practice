package com.examples.algorithms.sorting;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @SuppressWarnings("unchecked")
    @Override
    public void sort(T[] input) {

        T[] aux = (T[]) new Comparable[input.length];
        sort(input, aux, 0, input.length - 1);
    }

    private void sort(T[] input, T[] aux, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(input, aux, lo, mid);
        sort(input, aux, mid + 1, hi);
        merge(input, aux, lo, mid, hi);
    }

    private void merge(T[] input, T[] aux, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++) {
            aux[i] = input[i];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                input[k] = aux[j++];
            } else if (j > hi) {
                input[k] = aux[i++];
            } else if (less(aux, j, i)) {
                input[k] = aux[j++];
            } else {
                input[k] = aux[i++];
            }
        }
    }
}
