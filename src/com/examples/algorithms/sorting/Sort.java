package com.examples.algorithms.sorting;

public interface Sort<T extends Comparable<T>> {

    void sort(T[] input);

    default void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    default boolean less(T[] array, int i, int j) {
        return array[i].compareTo(array[j]) < 0;
    }
}
