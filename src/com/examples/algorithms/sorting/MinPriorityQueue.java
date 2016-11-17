package com.examples.algorithms.sorting;

public interface MinPriorityQueue<T extends Comparable<T>> {

    void insert(T key);

    T min();

    T removeMin();

    boolean isEmpty();

    int size();
}
