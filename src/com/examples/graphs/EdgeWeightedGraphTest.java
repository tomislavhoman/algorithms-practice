package com.examples.graphs;

public class EdgeWeightedGraphTest {

    public static void main(String[] args) {

        EdgeWeightedGraph graph = loadGraph();
        testGraph(graph);

        System.out.println("All ok");
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

    private static void testGraph(EdgeWeightedGraph graph) {

        assert graph.v() == 8;
        assert graph.e() == 16;

        testNeighbourhood(graph, 0, new EdgeWeightedGraph.Edge[]{
                        new EdgeWeightedGraph.Edge(6, 0, 0.58),
                        new EdgeWeightedGraph.Edge(0, 2, 0.26),
                        new EdgeWeightedGraph.Edge(0, 4, 0.38),
                        new EdgeWeightedGraph.Edge(0, 7, 0.16),
                }
        );

        testNeighbourhood(graph, 1, new EdgeWeightedGraph.Edge[]{
                        new EdgeWeightedGraph.Edge(1, 3, 0.29),
                        new EdgeWeightedGraph.Edge(1, 2, 0.36),
                        new EdgeWeightedGraph.Edge(1, 7, 0.19),
                        new EdgeWeightedGraph.Edge(1, 5, 0.32),
                }
        );

        testNeighbourhood(graph, 2, new EdgeWeightedGraph.Edge[]{
                        new EdgeWeightedGraph.Edge(6, 2, 0.40),
                        new EdgeWeightedGraph.Edge(2, 7, 0.34),
                        new EdgeWeightedGraph.Edge(1, 2, 0.36),
                        new EdgeWeightedGraph.Edge(0, 2, 0.26),
                        new EdgeWeightedGraph.Edge(2, 3, 0.17),
                }
        );

        testNeighbourhood(graph, 3, new EdgeWeightedGraph.Edge[]{
                        new EdgeWeightedGraph.Edge(3, 6, 0.52),
                        new EdgeWeightedGraph.Edge(1, 3, 0.29),
                        new EdgeWeightedGraph.Edge(2, 3, 0.17),
                }
        );

        testNeighbourhood(graph, 4, new EdgeWeightedGraph.Edge[]{
                        new EdgeWeightedGraph.Edge(6, 4, 0.93),
                        new EdgeWeightedGraph.Edge(0, 4, 0.38),
                        new EdgeWeightedGraph.Edge(4, 7, 0.37),
                        new EdgeWeightedGraph.Edge(4, 5, 0.35),
                }
        );

        testNeighbourhood(graph, 5, new EdgeWeightedGraph.Edge[]{
                        new EdgeWeightedGraph.Edge(1, 5, 0.32),
                        new EdgeWeightedGraph.Edge(5, 7, 0.28),
                        new EdgeWeightedGraph.Edge(4, 5, 0.35),
                }
        );

        testNeighbourhood(graph, 6, new EdgeWeightedGraph.Edge[]{
                        new EdgeWeightedGraph.Edge(6, 4, 0.93),
                        new EdgeWeightedGraph.Edge(6, 0, 0.58),
                        new EdgeWeightedGraph.Edge(3, 6, 0.52),
                        new EdgeWeightedGraph.Edge(6, 2, 0.40),
                }
        );

        testNeighbourhood(graph, 7, new EdgeWeightedGraph.Edge[]{
                        new EdgeWeightedGraph.Edge(2, 7, 0.34),
                        new EdgeWeightedGraph.Edge(1, 7, 0.19),
                        new EdgeWeightedGraph.Edge(0, 7, 0.16),
                        new EdgeWeightedGraph.Edge(5, 7, 0.28),
                        new EdgeWeightedGraph.Edge(4, 7, 0.37),
                }
        );

        testEdges(graph, new EdgeWeightedGraph.Edge[]{
                new EdgeWeightedGraph.Edge(5, 7, 0.28),
                new EdgeWeightedGraph.Edge(4, 5, 0.35),
                new EdgeWeightedGraph.Edge(4, 7, 0.37),
                new EdgeWeightedGraph.Edge(6, 4, 0.93),
                new EdgeWeightedGraph.Edge(3, 6, 0.52),
                new EdgeWeightedGraph.Edge(2, 3, 0.17),
                new EdgeWeightedGraph.Edge(2, 7, 0.34),
                new EdgeWeightedGraph.Edge(6, 2, 0.40),
                new EdgeWeightedGraph.Edge(1, 5, 0.32),
                new EdgeWeightedGraph.Edge(1, 7, 0.19),
                new EdgeWeightedGraph.Edge(1, 2, 0.36),
                new EdgeWeightedGraph.Edge(1, 3, 0.29),
                new EdgeWeightedGraph.Edge(0, 7, 0.16),
                new EdgeWeightedGraph.Edge(0, 4, 0.38),
                new EdgeWeightedGraph.Edge(0, 2, 0.26),
                new EdgeWeightedGraph.Edge(6, 0, 0.58),
        });
    }

    private static void testNeighbourhood(EdgeWeightedGraph graph, int v, EdgeWeightedGraph.Edge[] neighbours) {
        int i = 0;
        for (EdgeWeightedGraph.Edge edge : graph.adj(v)) {
            assert edge.either() == neighbours[i].either();
            assert edge.other(edge.either()) == neighbours[i].other(neighbours[i].either());
            assert edge.weight() == neighbours[i].weight();
            i++;
        }
    }

    private static void testEdges(EdgeWeightedGraph graph, EdgeWeightedGraph.Edge[] edges) {
        int i = 0;
        for (EdgeWeightedGraph.Edge edge : graph.edges()) {
            assert edge.either() == edges[i].either() : String.format("%dth edge failed", i);
            assert edge.other(edge.either()) == edges[i].other(edges[i].either()) : String.format("%dth edge failed", i);
            assert edge.weight() == edges[i].weight() : String.format("%dth edge failed", i);
            i++;
        }
    }
}
