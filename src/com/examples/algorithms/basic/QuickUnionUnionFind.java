package com.examples.algorithms.basic;

public class QuickUnionUnionFind implements UnionFind {


    private int ids[];
    private int count;

    public QuickUnionUnionFind(int size) {

        ids = new int[size];
        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }

        count = size;
    }

    @Override
    public void union(int p, int q) {

        if (connected(p, q)) {
            return;
        }

        ids[find(p)] = find(q);
        count--;
    }

    @Override
    public int find(int p) {

        int rootP = p;
        while (rootP != ids[rootP]) {
            rootP = ids[rootP];
        }
        return rootP;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
