package com.examples.algorithms.graphs;

public class UndirectedCycleTest {

    public static void main(String[] args) {

        testGraphWithCycle(new UndirectedCycle(loadGraphWithCycle()));
        testGraphWithoutCycle(new UndirectedCycle(loadGraphWithoutCycle()));

        System.out.println("all ok");
    }

    private static Graph loadGraphWithCycle() {

        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
        return graph;
    }

    private static Graph loadGraphWithoutCycle() {

        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(7, 8);
        return graph;
    }

    private static void testGraphWithCycle(UndirectedCycle undirectedCycle) {

        assert undirectedCycle.hasCycle();

        testCycle(undirectedCycle, new int[]{0, 6, 4, 5, 3, 4});
    }

    private static void testCycle(UndirectedCycle undirectedCycle, int[] cycle) {

        int i = 0;
        for (int v : undirectedCycle.cycle()) {
            assert v == cycle[i];
            i++;
        }
    }

    private static void testGraphWithoutCycle(UndirectedCycle undirectedCycle) {
        assert !undirectedCycle.hasCycle();
    }
}
