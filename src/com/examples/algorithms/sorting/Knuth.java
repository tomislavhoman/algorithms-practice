package com.examples.algorithms.sorting;

public class Knuth {

    public static <T extends Comparable<T>> void shuffle(T[] input) {

        for (int i = 0; i < input.length; i++) {
            int selected = i + (int) (Math.random() * (input.length - i));
            T temp = input[selected];
            input[selected] = input[i];
            input[i] = temp;
        }
    }
}
