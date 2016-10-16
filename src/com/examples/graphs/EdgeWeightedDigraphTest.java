package com.examples.graphs;

public class EdgeWeightedDigraphTest {

    public static void main(String[] args) {

        EdgeWeightedDigraph graph = loadGraph();
        testGraph(graph);

        System.out.println("All ok");
    }

    private static EdgeWeightedDigraph loadGraph() {

        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(8);

        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(4, 5, 0.35));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 4, 0.35));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(4, 7, 0.37));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 7, 0.28));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(7, 5, 0.28));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 1, 0.32));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(0, 4, 0.38));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(0, 2, 0.26));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(7, 3, 0.39));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(1, 3, 0.29));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(2, 7, 0.34));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 2, 0.40));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(3, 6, 0.52));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 0, 0.58));
        graph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 4, 0.93));

        return graph;
    }

    private static void testGraph(EdgeWeightedDigraph graph) {

        assert graph.v() == 8;
        assert graph.e() == 15;

        testNeighbourhood(graph, 0, new EdgeWeightedDigraph.DirectedEdge[]{
                        new EdgeWeightedDigraph.DirectedEdge(0, 2, 0.26),
                        new EdgeWeightedDigraph.DirectedEdge(0, 4, 0.38),
                }
        );

        testNeighbourhood(graph, 1, new EdgeWeightedDigraph.DirectedEdge[]{
                        new EdgeWeightedDigraph.DirectedEdge(1, 3, 0.29),
                }
        );

        testNeighbourhood(graph, 2, new EdgeWeightedDigraph.DirectedEdge[]{
                        new EdgeWeightedDigraph.DirectedEdge(2, 7, 0.34),
                }
        );

        testNeighbourhood(graph, 3, new EdgeWeightedDigraph.DirectedEdge[]{
                        new EdgeWeightedDigraph.DirectedEdge(3, 6, 0.52),
                }
        );

        testNeighbourhood(graph, 4, new EdgeWeightedDigraph.DirectedEdge[]{
                        new EdgeWeightedDigraph.DirectedEdge(4, 7, 0.37),
                        new EdgeWeightedDigraph.DirectedEdge(4, 5, 0.35),
                }
        );

        testNeighbourhood(graph, 5, new EdgeWeightedDigraph.DirectedEdge[]{
                        new EdgeWeightedDigraph.DirectedEdge(5, 1, 0.32),
                        new EdgeWeightedDigraph.DirectedEdge(5, 7, 0.28),
                        new EdgeWeightedDigraph.DirectedEdge(5, 4, 0.35),
                }
        );

        testNeighbourhood(graph, 6, new EdgeWeightedDigraph.DirectedEdge[]{
                        new EdgeWeightedDigraph.DirectedEdge(6, 4, 0.93),
                        new EdgeWeightedDigraph.DirectedEdge(6, 0, 0.58),
                        new EdgeWeightedDigraph.DirectedEdge(6, 2, 0.40),
                }
        );

        testNeighbourhood(graph, 7, new EdgeWeightedDigraph.DirectedEdge[]{
                        new EdgeWeightedDigraph.DirectedEdge(7, 3, 0.39),
                        new EdgeWeightedDigraph.DirectedEdge(7, 5, 0.28),
                }
        );

        testEdges(graph, new EdgeWeightedDigraph.DirectedEdge[]{
                new EdgeWeightedDigraph.DirectedEdge(7, 5, 0.28),
                new EdgeWeightedDigraph.DirectedEdge(7, 3, 0.39),
                new EdgeWeightedDigraph.DirectedEdge(6, 2, 0.40),
                new EdgeWeightedDigraph.DirectedEdge(6, 0, 0.58),
                new EdgeWeightedDigraph.DirectedEdge(6, 4, 0.93),
                new EdgeWeightedDigraph.DirectedEdge(5, 4, 0.35),
                new EdgeWeightedDigraph.DirectedEdge(5, 7, 0.28),
                new EdgeWeightedDigraph.DirectedEdge(5, 1, 0.32),
                new EdgeWeightedDigraph.DirectedEdge(4, 5, 0.35),
                new EdgeWeightedDigraph.DirectedEdge(4, 7, 0.37),
                new EdgeWeightedDigraph.DirectedEdge(3, 6, 0.52),
                new EdgeWeightedDigraph.DirectedEdge(2, 7, 0.34),
                new EdgeWeightedDigraph.DirectedEdge(1, 3, 0.29),
                new EdgeWeightedDigraph.DirectedEdge(0, 4, 0.38),
                new EdgeWeightedDigraph.DirectedEdge(0, 2, 0.26),

        });
    }

    private static void testNeighbourhood(EdgeWeightedDigraph graph, int v, EdgeWeightedDigraph.DirectedEdge[] neighbours) {
        int i = 0;
        for (EdgeWeightedDigraph.DirectedEdge edge : graph.adj(v)) {
            assert edge.from() == neighbours[i].from();
            assert edge.to() == neighbours[i].to();
            assert edge.weight() == neighbours[i].weight();
            i++;
        }
    }

    private static void testEdges(EdgeWeightedDigraph graph, EdgeWeightedDigraph.DirectedEdge[] edges) {
        int i = 0;
        for (EdgeWeightedDigraph.DirectedEdge edge : graph.edges()) {
            assert edge.from() == edges[i].from() : String.format("%dth edge failed", i);
            assert edge.to() == edges[i].to() : String.format("%dth edge failed", i);
            assert edge.weight() == edges[i].weight() : String.format("%dth edge failed", i);
            i++;
        }
    }
}
