package com.examples.algorithms.graphs;

public class TopologicalOrderTest {

    public static void main(String[] args) {

        testNoTopologicalOrder(new TopologicalOrder(loadNotDAG()));
        testTopologicalOrder(new TopologicalOrder(loadDAG()));
        System.out.println("Everything cool!!!");
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

    private static Digraph loadNotDAG() {

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

    private static void testTopologicalOrder(TopologicalOrder topologicalOrder) {

        assert topologicalOrder.isDAG();

        int[] order = new int[]{8, 7, 2, 3, 0, 6, 9, 10, 11, 12, 1, 5, 4};

        int i = 0;
        for (int v : topologicalOrder.order()) {
            assert v == order[i];
            i++;
        }
    }

    private static void testNoTopologicalOrder(TopologicalOrder topologicalOrder) {

        assert !topologicalOrder.isDAG();
    }
}
