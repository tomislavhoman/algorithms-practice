package com.examples.algorithms.sorting;

public class HeapSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] input) {

        // Not a nice move copying just because of indices...
        T[] aux = moveRight(input);

        int size = aux.length - 1;
        for (int i = size / 2; i >= 1; i--) {
            sink(aux, i, size);
        }

        while (size > 1) {
            swap(aux, 1, size--);
            sink(aux, 1, size);
        }

        //... and then copying back
        for (int i = 0; i < input.length; i++) {
            input[i] = aux[i + 1];
        }
    }

    private void sink(T[] heap, int index, int size) {

        int i = index;

        while (2 * i <= size) {
            int child = 2 * i;

            if (child < size && less(heap, child, child + 1)) {
                child = child + 1;
            }

            if (less(heap, i, child)) {
                swap(heap, i, child);
                i = child;
            } else {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private T[] moveRight(T[] input) {
        T[] aux = (T[]) new Comparable[input.length + 1];
        for (int i = 0; i < input.length; i++) {
            aux[i + 1] = input[i];
        }
        return aux;
    }
}
