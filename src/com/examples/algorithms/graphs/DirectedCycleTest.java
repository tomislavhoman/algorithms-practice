package com.examples.algorithms.graphs;

public class DirectedCycleTest {

    public static void main(String[] args) {

        testNoCycle(new DirectedCycle(loadDigraphWithoutCycle()));
        testCycle(new DirectedCycle(loadDigraphWithCycle()));
        testNoWeightedCycle(new DirectedCycle(loadWeightedDigraphWithoutCycle()));
        testWeightedCycle(new DirectedCycle(loadWeightedDigraphWithCycle()));
        System.out.println("All ok!");
    }

    private static Digraph loadDigraphWithoutCycle() {

        Digraph digraph = new Digraph(13);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 5);
        digraph.addEdge(0, 6);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 5);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        digraph.addEdge(8, 7);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(9, 12);
        digraph.addEdge(11, 12);
        return digraph;
    }

    private static Digraph loadDigraphWithCycle() {

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

    private static void testNoCycle(DirectedCycle directedCycle) {
        assert !directedCycle.hasCycle();
    }

    private static void testCycle(DirectedCycle directedCycle) {

        assert directedCycle.hasCycle();

        int[] cycle = new int[]{5, 4, 3, 5};
        int i = 0;
        for (int v : directedCycle.cycle()) {
            assert v == cycle[i];
            i++;
        }
    }

    private static EdgeWeightedDigraph loadWeightedDigraphWithoutCycle() {

        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(8);
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 4, 0.35));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(4, 7, 0.37));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 7, 0.28));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 1, 0.32));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(4, 0, 0.28));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(0, 2, 0.26));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(3, 7, 0.39));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(1, 3, 0.29));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(7, 2, 0.34));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 2, 0.40));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(3, 6, 0.52));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 0, 0.58));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 4, 0.93));
        return digraph;
    }

    private static EdgeWeightedDigraph loadWeightedDigraphWithCycle() {

        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(8);
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(4, 5, 0.35));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 4, 0.35));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(4, 7, 0.37));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 7, 0.28));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(7, 5, 0.28));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 1, 0.32));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(0, 4, 0.38));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(0, 2, 0.26));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(7, 3, 0.39));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(1, 3, 0.29));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(2, 7, 0.34));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 2, 0.40));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(3, 6, 0.52));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 0, 0.58));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 4, 0.93));
        return digraph;
    }

    private static void testNoWeightedCycle(DirectedCycle directedCycle) {
        assert !directedCycle.hasCycle();
    }

    private static void testWeightedCycle(DirectedCycle directedCycle) {
        assert directedCycle.hasCycle();
    }
}
