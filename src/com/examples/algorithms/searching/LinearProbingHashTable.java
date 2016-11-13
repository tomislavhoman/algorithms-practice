package com.examples.algorithms.searching;

public class LinearProbingHashTable<Key, Value> implements SymbolTable<Key, Value> {

    private static final int INITIAL_TABLE_SIZE = 3;

    private Key[] keys;
    private Value[] values;

    private int size;

    @SuppressWarnings("unchecked")
    public LinearProbingHashTable() {
        this.keys = (Key[]) new Object[INITIAL_TABLE_SIZE];
        this.values = (Value[]) new Object[INITIAL_TABLE_SIZE];
    }

    @Override
    public Value get(Key key) {

        int i = hash(key);
        while (keys[i] != null && !keys[i].equals(key)) {
            i = (i + 1) % keys.length;
        }
        return values[i];
    }

    @Override
    public void put(Key key, Value value) {

        /*
           Doing classic array resizing because I have small number of samples.
           In reality I should resize the table when it's half full, ideally not
           to 2x, but to prime number near 2x
         */
        if (size >= keys.length) {
            resize(keys.length * 2);
        }

        int i = hash(key);
        while (keys[i] != null && !keys[i].equals(key)) {
            i = (i + 1) % keys.length;
        }

        if (keys[i] == null) {
            size++;
        }

        keys[i] = key;
        values[i] = value;
    }

    @Override
    public void delete(Key key) {

        if (!contains(key)) {
            return;
        }

        int i = hash(key);
        while (!keys[i].equals(key)) {
            i = (i + 1) % keys.length;
        }

        keys[i] = null;
        values[i] = null;
        i = (i + 1) % keys.length;
        while (keys[i] != null) {
            Key tempKey = keys[i];
            Value tempValue = values[i];

            keys[i] = null;
            values[i] = null;

            size--;
            put(tempKey, tempValue);

            i = (i + 1) % keys.length;
        }

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

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % keys.length;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        Key[] tempKeys = keys;
        Value[] tempValues = values;

        keys = (Key[]) new Object[newSize];
        values = (Value[]) new Object[newSize];

        size = 0;
        for (int i = 0; i < tempKeys.length; i++) {
            if (tempKeys[i] != null) {
                put(tempKeys[i], tempValues[i]);
            }
        }
    }
}
