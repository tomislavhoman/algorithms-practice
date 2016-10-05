package com.examples.basic;

public interface Stack<Item> {

    void push(Item item);

    Item pop();

    boolean isEmpty();
}
