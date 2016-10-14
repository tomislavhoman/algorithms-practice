package com.examples.searching;

public class RedBlackBinarySearchTree<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {

        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value) {

        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            newNode.size = 1;
            newNode.color = RED;
            return newNode;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        if (!isRed(node.left) && isRed(node.right)) {
            node = rotateLeft(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            node = flipColors(node);
        }

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    // My balanced tree doesn't balance when deleting :( Don't delete :)
    private Node delete(Node node, Key key) {

        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {

            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node min(Node node) {

        if (node.left == null) {
            return node;
        }

        return min(node.left);
    }

    private Node deleteMin(Node node) {

        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }

        return node.color == RED;
    }

    private Node rotateLeft(Node node) {

        Node t = node.right;
        node.right = t.left;
        t.left = node;
        t.color = node.color;
        node.color = RED;
        t.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);

        return t;
    }

    private Node rotateRight(Node node) {

        Node t = node.left;
        node.left = t.right;
        t.right = node;
        t.color = node.color;
        node.color = RED;
        t.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);

        return t;
    }

    private Node flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
        return node;
    }

    private class Node {
        Key key;
        Value value;
        int size;
        boolean color;
        Node left;
        Node right;

        @Override
        public String toString() {
            return key.toString();
        }
    }
}
