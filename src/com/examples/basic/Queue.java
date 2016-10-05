package com.examples.basic;

public interface Queue<Item> {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();
}
