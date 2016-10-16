package com.examples.basic;

public interface Stack<Item> extends Iterable<Item> {

    void push(Item item);

    Item pop();

    boolean isEmpty();
}
