package com.examples.algorithms.graphs;

public class BipartiteGraphTest {

    public static void main(String[] args) {

        assert (new BipartiteGraph(loadBipartiteGraph()).isBipartite());
        assert !(new BipartiteGraph(loadNonBipartiteGraph()).isBipartite());
        System.out.println("all ok");
    }

    private static Graph loadBipartiteGraph() {
        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(1, 3);
        graph.addEdge(0, 1);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
        graph.addEdge(6, 7);
        graph.addEdge(8, 10);
        graph.addEdge(12, 10);
        return graph;
    }

    private static Graph loadNonBipartiteGraph() {
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
}
