package com.examples.algorithms.graphs;

public class GraphTest {

    public static void main(String[] args) {

        Graph graph = loadGraph();
        testGraph(graph);

        System.out.println("All ok");
    }

    private static Graph loadGraph() {

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

    private static void testGraph(Graph graph) {

        assert graph.v() == 13;
        assert graph.e() == 13;

        testNeighbourhood(graph, 0, new int[]{6, 2, 1, 5});
        testNeighbourhood(graph, 1, new int[]{0});
        testNeighbourhood(graph, 2, new int[]{0});
        testNeighbourhood(graph, 3, new int[]{5, 4});
        testNeighbourhood(graph, 4, new int[]{5, 6, 3});
        testNeighbourhood(graph, 5, new int[]{3, 4, 0});
        testNeighbourhood(graph, 6, new int[]{0, 4});
        testNeighbourhood(graph, 7, new int[]{8});
        testNeighbourhood(graph, 8, new int[]{7});
        testNeighbourhood(graph, 9, new int[]{11, 10, 12});
        testNeighbourhood(graph, 10, new int[]{9});
        testNeighbourhood(graph, 11, new int[]{9, 12});
        testNeighbourhood(graph, 12, new int[]{11, 9});
    }

    private static void testNeighbourhood(Graph graph, int v, int[] neighbours) {
        int i = 0;
        for (int w : graph.adj(v)) {
            assert neighbours[i] == w;
            i++;
        }
    }
}
