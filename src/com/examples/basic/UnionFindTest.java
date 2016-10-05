package com.examples.basic;

public class UnionFindTest {

    public static void main(String[] args) {

        test(new QuickFindUnionFind(10));
    }

    private static void test(UnionFind unionFind) {

        assert unionFind.count() == 10;
        unionNotConnected(unionFind, 4, 3);
        assert unionFind.count() == 9;
        unionNotConnected(unionFind, 3, 8);
        assert unionFind.count() == 8;
        unionNotConnected(unionFind, 6, 5);
        assert unionFind.count() == 7;
        unionNotConnected(unionFind, 9, 4);
        assert unionFind.count() == 6;
        unionNotConnected(unionFind, 2, 1);
        assert unionFind.count() == 5;
        assertConnected(unionFind, 8, 9);
        assert unionFind.count() == 5;
        unionNotConnected(unionFind, 5, 0);
        assert unionFind.count() == 4;
        unionNotConnected(unionFind, 7, 2);
        assert unionFind.count() == 3;
        unionNotConnected(unionFind, 6, 1);
        assert unionFind.count() == 2;
        assertConnected(unionFind, 1, 0);
        assert unionFind.count() == 2;
        assertConnected(unionFind, 6, 7);
        assert unionFind.count() == 2;

        assert unionFind.find(0) == 1;
        assert unionFind.find(1) == 1;
        assert unionFind.find(2) == 1;
        assert unionFind.find(3) == 8;
        assert unionFind.find(4) == 8;
        assert unionFind.find(5) == 1;
        assert unionFind.find(6) == 1;
        assert unionFind.find(7) == 1;
        assert unionFind.find(8) == 8;
        assert unionFind.find(9) == 8;
    }

    private static void unionNotConnected(UnionFind unionFind, int p, int q) {
        assert !unionFind.connected(p, q) : String.format("%d and %d shouldn't be connected", p, q);

        unionFind.union(p, q);
        assertConnected(unionFind, p, q);
    }

    private static void assertConnected(UnionFind unionFind, int p, int q) {
        assert unionFind.connected(p, q) : String.format("%d and %d should be connected", p, q);
    }
}
