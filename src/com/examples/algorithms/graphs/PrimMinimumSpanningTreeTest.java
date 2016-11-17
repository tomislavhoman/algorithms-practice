package com.examples.algorithms.graphs;

public class PrimMinimumSpanningTreeTest {

    public static void main(String[] args) {
        testMinimumSpanningTree(new PrimMinimumSpanningTree(loadGraph()));
        System.out.println("Found MST!");
    }

    private static EdgeWeightedGraph loadGraph() {

        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.addEdge(new EdgeWeightedGraph.Edge(4, 5, 0.35));
        graph.addEdge(new EdgeWeightedGraph.Edge(4, 7, 0.37));
        graph.addEdge(new EdgeWeightedGraph.Edge(5, 7, 0.28));
        graph.addEdge(new EdgeWeightedGraph.Edge(0, 7, 0.16));
        graph.addEdge(new EdgeWeightedGraph.Edge(1, 5, 0.32));
        graph.addEdge(new EdgeWeightedGraph.Edge(0, 4, 0.38));
        graph.addEdge(new EdgeWeightedGraph.Edge(2, 3, 0.17));
        graph.addEdge(new EdgeWeightedGraph.Edge(1, 7, 0.19));
        graph.addEdge(new EdgeWeightedGraph.Edge(0, 2, 0.26));
        graph.addEdge(new EdgeWeightedGraph.Edge(1, 2, 0.36));
        graph.addEdge(new EdgeWeightedGraph.Edge(1, 3, 0.29));
        graph.addEdge(new EdgeWeightedGraph.Edge(2, 7, 0.34));
        graph.addEdge(new EdgeWeightedGraph.Edge(6, 2, 0.40));
        graph.addEdge(new EdgeWeightedGraph.Edge(3, 6, 0.52));
        graph.addEdge(new EdgeWeightedGraph.Edge(6, 0, 0.58));
        graph.addEdge(new EdgeWeightedGraph.Edge(6, 4, 0.93));
        return graph;

    }

    private static void testMinimumSpanningTree(PrimMinimumSpanningTree primMinimumSpanningTree) {
        EdgeWeightedGraph.Edge[] edges = new EdgeWeightedGraph.Edge[]{
                new EdgeWeightedGraph.Edge(0, 7, 0.16),
                new EdgeWeightedGraph.Edge(1, 7, 0.19),
                new EdgeWeightedGraph.Edge(0, 2, 0.26),
                new EdgeWeightedGraph.Edge(2, 3, 0.17),
                new EdgeWeightedGraph.Edge(5, 7, 0.28),
                new EdgeWeightedGraph.Edge(4, 5, 0.35),
                new EdgeWeightedGraph.Edge(6, 2, 0.40)
        };

        int i = 0;
        for (EdgeWeightedGraph.Edge edge : primMinimumSpanningTree.edges()) {
            assert edges[i].toString().equals(edge.toString());
            i++;
        }

        assert primMinimumSpanningTree.weight() == 1.81;
    }
}
