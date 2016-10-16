package com.examples.basic;

import java.util.Iterator;

public class LinkedStack<Item> implements Stack<Item> {

    private Node head;

    @Override
    public void push(Item item) {

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = head;

        head = newNode;
    }

    @Override
    public Item pop() {

        Item item = head.item; // No null checks for brevity
        head = head.next;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class StackIterator implements Iterator<Item> {

        private Node current;

        private StackIterator() {
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
