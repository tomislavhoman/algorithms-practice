package com.examples.basic;

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

    private class Node {
        Item item;
        Node next;
    }
}
