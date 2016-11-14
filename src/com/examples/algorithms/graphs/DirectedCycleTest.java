package com.examples.algorithms.graphs;

public class DirectedCycleTest {

    public static void main(String[] args) {

        testNoCycle(new DirectedCycle(loadDigraphWithoutCycle()));
        testCycle(new DirectedCycle(loadDigraphWithCycle()));
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
}
