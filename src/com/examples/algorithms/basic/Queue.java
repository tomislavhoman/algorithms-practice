package com.examples.algorithms.basic;

public interface Queue<Item> extends Iterable<Item> {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();
}
