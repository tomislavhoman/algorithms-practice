package com.examples.basic;

import java.util.Iterator;

public class LinkedListBag<Item> implements Bag<Item> {

    private Node head;
    private int size;

    @Override
    public void add(Item item) {

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = head;

        head = newNode;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class BagIterator implements Iterator<Item> {

        private Node current;

        private BagIterator() {
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
