package com.examples.algorithms.graphs;

public class StronglyConnectedComponentsTest {

    public static void main(String[] args) {

        testDigraph(new StronglyConnectedComponents(loadDigraph()));
        testDAG(new StronglyConnectedComponents(loadDAG()));
        System.out.println("Everything is fine!!!");
    }

    private static Digraph loadDigraph() {

        Digraph digraph = new Digraph(13);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 5);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 5);
        digraph.addEdge(4, 2);
        digraph.addEdge(4, 3);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 0);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        digraph.addEdge(7, 8);
        digraph.addEdge(8, 7);
        digraph.addEdge(8, 9);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(10, 12);
        digraph.addEdge(11, 4);
        digraph.addEdge(11, 12);
        digraph.addEdge(12, 9);
        return digraph;
    }

    private static Digraph loadDAG() {
        Digraph digraph = new Digraph(13);
        digraph.addEdge(2, 3);
        digraph.addEdge(0, 6);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 0);
        digraph.addEdge(11, 12);
        digraph.addEdge(9, 12);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(3, 5);
        digraph.addEdge(8, 7);
        digraph.addEdge(5, 4);
        digraph.addEdge(0, 5);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        return digraph;
    }

    private static void testDigraph(StronglyConnectedComponents scc) {

        assert scc.count() == 5;

        assert scc.id(1) == 0;

        assert scc.id(0) == 1;
        assert scc.id(2) == 1;
        assert scc.id(3) == 1;
        assert scc.id(4) == 1;
        assert scc.id(5) == 1;

        assert scc.id(9) == 2;
        assert scc.id(10) == 2;
        assert scc.id(11) == 2;
        assert scc.id(12) == 2;

        assert scc.id(6) == 3;

        assert scc.id(7) == 4;
        assert scc.id(8) == 4;

        assert scc.stronglyConnected(1, 1);
        assert !scc.stronglyConnected(1, 0);
        assert !scc.stronglyConnected(1, 2);

        assert scc.stronglyConnected(0, 2);
        assert scc.stronglyConnected(0, 3);
        assert scc.stronglyConnected(0, 4);
        assert !scc.stronglyConnected(0, 6);
        assert !scc.stronglyConnected(0, 9);
    }

    private static void testDAG(StronglyConnectedComponents scc) {

        assert scc.count() == 13;

        assert scc.id(12) == 0;
        assert scc.id(11) == 1;
        assert scc.id(10) == 2;
        assert scc.id(9) == 3;
        assert scc.id(4) == 4;
        assert scc.id(5) == 5;
        assert scc.id(6) == 6;
        assert scc.id(7) == 7;
        assert scc.id(8) == 8;
        assert scc.id(3) == 9;
        assert scc.id(1) == 10;
        assert scc.id(0) == 11;
        assert scc.id(2) == 12;
    }

}
