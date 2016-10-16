package com.examples.basic;

public interface Bag<Item> extends Iterable<Item> {

    void add(Item item);

    boolean isEmpty();

    int size();
}
