package com.examples.basic;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

public class ResizableArrayStack<Item> implements Stack<Item> {

    private static final int INITIAL_SIZE = 4;

    private int current = 0;
    private Item[] stack;

    @SuppressWarnings("unchecked")
    public ResizableArrayStack() {
        this.stack = (Item[]) new Object[INITIAL_SIZE];
    }

    @Override
    public void push(Item item) {
        growIfNecessary();
        stack[current++] = item;
    }

    @Override
    public Item pop() {

        Item item = stack[--current];
        stack[current] = null;
        shrinkIfNecessary();
        return item;
    }

    @Override
    public boolean isEmpty() {
        return current == 0;
    }

    private void growIfNecessary() {
        if (current >= stack.length) {
            resize(stack.length * 2);
        }
    }

    private void shrinkIfNecessary() {
        if (current <= stack.length / 4 && current > 0) {
            resize(stack.length / 2);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {

        Item[] newStack = (Item[]) new Object[newSize];
        for (int i = 0; i < current; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }

    @Override
    public Iterator<Item> iterator() {
        throw new NotImplementedException();
    }
}
