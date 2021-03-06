package com.examples.algorithms.sorting;

public interface MaxPriorityQueue<T extends Comparable<T>> {

    void insert(T key);

    T max();

    T removeMax();

    boolean isEmpty();

    int size();
}
