package com.examples.basic;

public class WeightedQuickUnionUnionFind implements UnionFind {

    private int[] ids;
    private int[] sizes;
    private int count;

    public WeightedQuickUnionUnionFind(int size) {

        ids = new int[size];
        sizes = new int[size];

        for (int i = 0; i < size; i++) {
            ids[i] = i;
            sizes[i] = 1;
        }

        count = size;
    }

    @Override
    public void union(int p, int q) {

        if (connected(p, q)) {
            return;
        }

        int rootP = find(p);
        int rootQ = find(q);

        if (sizes[rootP] >= sizes[rootQ]) {
            ids[rootQ] = rootP;
            sizes[rootP] += sizes[rootQ];
        } else {
            ids[rootP] = rootQ;
            sizes[rootQ] += sizes[rootP];
        }

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
