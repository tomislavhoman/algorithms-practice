package com.examples.algorithms.searching;

public interface SymbolTable<Key, Value> {

    Value get(Key key);

    void put(Key key, Value value);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();
}
