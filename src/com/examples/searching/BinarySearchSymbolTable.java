package com.examples.searching;

public class BinarySearchSymbolTable<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public BinarySearchSymbolTable() {
        keys = (Key[]) new Comparable[4];
        values = (Value[]) new Object[4];
    }

    @Override
    public Value get(Key key) {

        int rank = rank(key);
        if (areEqual(rank, key)) {
            return values[rank];
        } else {
            return null;
        }
    }

    @Override
    public void put(Key key, Value value) {
        if (size >= keys.length) {
            resize(2 * keys.length);
        }

        int rank = rank(key);
        if (areEqual(rank, key)) {
            values[rank] = value;
            return;
        }

        insert(rank, key, value);
        size++;
    }

    @Override
    public void delete(Key key) {

        int rank = rank(key);
        if (!areEqual(rank, key)) {
            return;
        }

        delete(rank, key);
        size--;

        if (size > 0 && size <= keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private int rank(Key key) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;
    }

    private boolean areEqual(int rank, Key key) {
        return keys[rank] != null && keys[rank].compareTo(key) == 0;
    }

    private void insert(int position, Key key, Value value) {
        for (int i = size; i > position; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }

        keys[position] = key;
        values[position] = value;
    }

    private void delete(int position, Key key) {
        for (int i = position; i < size; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }

        keys[size - 1] = null;
        values[size - 1] = null;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        Key[] newKeys = (Key[]) new Comparable[newSize];
        Value[] newValues = (Value[]) new Object[newSize];

        for (int i = 0, minSize = Math.min(keys.length, newSize); i < minSize; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }

        keys = newKeys;
        values = newValues;
    }
}
