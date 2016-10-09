package com.examples.sorting;

public class HeapMaxPriorityQueue<T extends Comparable<T>> implements MaxPriorityQueue<T> {

    private T[] heap;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public HeapMaxPriorityQueue(int maxSize) {
        heap = (T[]) new Comparable[maxSize + 1];
    }

    @Override
    public void insert(T key) {

        size++;
        heap[size] = key;
        swim(size);
    }

    @Override
    public T max() {
        return heap[1];
    }

    @Override
    public T removeMax() {
        T max = max();
        heap[1] = heap[size];
        heap[size] = null;
        size--;
        sink(1);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void swim(int index) {

        int i = index;
        while (i > 1 && less(i / 2, i)) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    private void sink(int index) {

        int i = index;

        while (2 * i <= size) {
            int child = 2 * i;

            if (child < size && less(child, child + 1)) {
                child = child + 1;
            }

            if (less(i, child)) {
                swap(i, child);
                i = child;
            } else {
                break;
            }
        }

    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
