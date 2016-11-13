package com.examples.algorithms.graphs;

public class DigraphTest {

    public static void main(String[] args) {

        Digraph graph = loadGraph();
        testGraph(graph);
        testReverseGraph(graph.reverse());

        System.out.println("All ok");
    }

    private static Digraph loadGraph() {

        Digraph graph = new Digraph(13);

        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);
        graph.addEdge(6, 4);
        graph.addEdge(6, 9);
        graph.addEdge(7, 6);
        graph.addEdge(8, 7);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        return graph;
    }

    private static void testGraph(Digraph graph) {

        assert graph.v() == 13;
        assert graph.e() == 15;

        testNeighbourhood(graph, 0, new int[]{6, 5, 1});
        testNeighbourhood(graph, 2, new int[]{3, 0});
        testNeighbourhood(graph, 3, new int[]{5});
        testNeighbourhood(graph, 5, new int[]{4});
        testNeighbourhood(graph, 6, new int[]{9, 4});
        testNeighbourhood(graph, 7, new int[]{6});
        testNeighbourhood(graph, 8, new int[]{7});
        testNeighbourhood(graph, 9, new int[]{12, 11, 10});
        testNeighbourhood(graph, 11, new int[]{12});
    }

    private static void testReverseGraph(Digraph graph) {

        assert graph.v() == 13;
        assert graph.e() == 15;

        testNeighbourhood(graph, 0, new int[]{2});
        testNeighbourhood(graph, 1, new int[]{0});
        testNeighbourhood(graph, 3, new int[]{2});
        testNeighbourhood(graph, 4, new int[]{6, 5});
        testNeighbourhood(graph, 5, new int[]{3, 0});
        testNeighbourhood(graph, 6, new int[]{7, 0});
        testNeighbourhood(graph, 7, new int[]{8});
        testNeighbourhood(graph, 9, new int[]{6});
        testNeighbourhood(graph, 10, new int[]{9});
        testNeighbourhood(graph, 11, new int[]{9});
        testNeighbourhood(graph, 12, new int[]{11, 9});
    }

    private static void testNeighbourhood(Digraph graph, int v, int[] neighbours) {
        int i = 0;
        for (int w : graph.adj(v)) {
            assert neighbours[i] == w;
            i++;
        }
    }
}
