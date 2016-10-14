package com.examples.searching;

public class SeparateChainingHashTable<Key, Value> implements SymbolTable<Key, Value> {

    private static final int TABLE_SIZE = 5;

    private SequentialSymbolTable<Key, Value>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public SeparateChainingHashTable() {
        this.table = (SequentialSymbolTable<Key, Value>[]) new SequentialSymbolTable[TABLE_SIZE];

        for (int i = 0; i < table.length; i++) {
            table[i] = new SequentialSymbolTable<>();
        }
    }

    @Override
    public Value get(Key key) {
        return table[hash(key)].get(key);
    }

    @Override
    public void put(Key key, Value value) {
        if (!contains(key)) {
            table[hash(key)].put(key, value);
            size++;
        }
    }

    @Override
    public void delete(Key key) {
        if (contains(key)) {
            table[hash(key)].delete(key);
            size--;
        }
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
        return size;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }
}
