package com.examples.basic;

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

    private class Node {
        Item item;
        Node next;
    }
}
