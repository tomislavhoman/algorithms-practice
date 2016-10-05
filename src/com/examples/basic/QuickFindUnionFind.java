package com.examples.basic;

public class QuickFindUnionFind implements UnionFind {

    private int[] ids;
    private int count = 0;

    public QuickFindUnionFind(int size) {

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

        int idp = ids[p];
        int idq = ids[q];
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == idp) {
                ids[i] = idq;
            }
        }

        count--;
    }

    @Override
    public int find(int p) {
        return ids[p];
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
