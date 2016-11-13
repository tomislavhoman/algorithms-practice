package com.examples.algorithms.searching;

public class SequentialSymbolTable<Key, Value> implements SymbolTable<Key, Value> {

    private Node head;
    private int size;

    @Override
    public Value get(Key key) {

        for (Node current = head; current != null; current = current.next) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }

        return null;
    }

    @Override
    public void put(Key key, Value value) {

        Node current;
        for (current = head; current != null; current = current.next) {
            if (current.key.equals(key)) {
                current.value = value;
                break;
            }
        }

        if (current == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    @Override
    public void delete(Key key) {

        if (head != null && head.key.equals(key)) {
            head = null;
            size--;
            return;
        }
        for (Node current = head; current != null && current.next != null; current = current.next) {

            if (current.next.key.equals(key)) {
                current.next = current.next.next;
                size--;
                break;
            }
        }
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        Key key;
        Value value;
        Node next;
    }
}
