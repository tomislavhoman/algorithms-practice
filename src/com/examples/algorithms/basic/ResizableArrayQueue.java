package com.examples.algorithms.basic;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

public class ResizableArrayQueue<Item> implements Queue<Item> {

    private static final int INITIAL_SIZE = 4;

    private Item[] queue;

    private int head = 0;
    private int tail = 0;

    private boolean isEmpty = true;

    @SuppressWarnings("unchecked")
    public ResizableArrayQueue() {
        this.queue = (Item[]) new Object[INITIAL_SIZE];
    }

    @Override
    public void enqueue(Item item) {

        if (isFull()) {
            resize(queue.length * 2);
        }

        queue[tail] = item;
        tail = (tail + 1) % queue.length;

        if (tail != head) {
            isEmpty = false;
        }
    }

    @Override
    public Item dequeue() {

        Item item = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;

        if (head == tail) {
            isEmpty = true;
        }

        if (!isEmpty && getSize() < queue.length / 4) {
            resize(queue.length / 2);
        }

        return item;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    private boolean isFull() {
        return !isEmpty && head == tail;
    }

    private int getSize() {

        if (isEmpty) {
            return 0;
        } else if (isFull()) {
            return queue.length;
        } else if (tail > head) {
            return tail - head;
        } else {
            return queue.length - (head - tail);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {

        Item[] newQueue = (Item[]) new Object[newSize];
        int size = getSize();
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(head + i) % queue.length];
        }

        head = 0;
        tail = size;

        queue = newQueue;
    }

    @Override
    public Iterator<Item> iterator() {
        throw new NotImplementedException();
    }
}
