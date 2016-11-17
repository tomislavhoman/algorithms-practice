package com.examples.algorithms.graphs;

public class DijkstraTest {

    public static void main(String[] args) {
        testDijkstra(new Dijkstra(loadDigraph(), 0));
        System.out.println("Dijkstra ok!");
    }

    private static EdgeWeightedDigraph loadDigraph() {

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

    private static void testDijkstra(Dijkstra dijkstra) {

        assert dijkstra.hasPathTo(0);
        assert dijkstra.hasPathTo(1);
        assert dijkstra.hasPathTo(2);
        assert dijkstra.hasPathTo(3);
        assert dijkstra.hasPathTo(4);
        assert dijkstra.hasPathTo(5);
        assert dijkstra.hasPathTo(6);
        assert dijkstra.hasPathTo(7);

        assert dijkstra.distTo(0) == 0.00;
        assert dijkstra.distTo(1) == 1.05;
        assert dijkstra.distTo(2) == 0.26;
        assert dijkstra.distTo(3) == 0.99;
        assert dijkstra.distTo(4) == 0.38;
        assert dijkstra.distTo(5) == 0.73;
        assert dijkstra.distTo(6) == 1.51;
        assert dijkstra.distTo(7) == 0.60;

        EdgeWeightedDigraph.DirectedEdge[] pathTo6 = new EdgeWeightedDigraph.DirectedEdge[]{
                new EdgeWeightedDigraph.DirectedEdge(0, 2, 0.26),
                new EdgeWeightedDigraph.DirectedEdge(2, 7, 0.34),
                new EdgeWeightedDigraph.DirectedEdge(7, 3, 0.39),
                new EdgeWeightedDigraph.DirectedEdge(3, 6, 0.52),
        };

        int i = 0;
        for (EdgeWeightedDigraph.DirectedEdge edge : dijkstra.pathTo(6)) {
            assert pathTo6[i].toString().equals(edge.toString());
            i++;
        }
    }
}
