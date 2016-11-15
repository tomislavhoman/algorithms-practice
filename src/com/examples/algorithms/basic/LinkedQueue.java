package com.examples.algorithms.basic;

import java.util.Iterator;

public class LinkedQueue<Item> implements Queue<Item> {

    private Node head;
    private Node tail;

    @Override
    public void enqueue(Item item) {

        Node node = new Node();
        node.item = item;

        if (tail != null) {
            tail.next = node;
        }

        tail = node;

        if (head == null) {
            head = node;
        }
    }

    @Override
    public Item dequeue() {

        Item item = head.item; // No null checks for brevity

        head = head.next;

        if (head == null) {
            tail = null;
        }

        return item;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class QueueIterator implements Iterator<Item> {

        private Node current;

        private QueueIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
