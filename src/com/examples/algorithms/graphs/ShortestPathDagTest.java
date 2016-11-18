package com.examples.algorithms.graphs;

public class ShortestPathDagTest {

    public static void main(String[] args) {
        testShortestPaths(new ShortestPathsDag(loadGraph(), 5));
        System.out.println("Shortest path in DAG found!");
    }

    private static EdgeWeightedDigraph loadGraph() {

        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(8);
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 4, 0.35));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(4, 7, 0.37));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 7, 0.28));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(5, 1, 0.32));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(4, 0, 0.28));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(0, 2, 0.26));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(3, 7, 0.39));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(1, 3, 0.29));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(7, 2, 0.34));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 2, 0.40));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(3, 6, 0.52));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 0, 0.58));
        digraph.addEdge(new EdgeWeightedDigraph.DirectedEdge(6, 4, 0.93));
        return digraph;
    }

    private static void testShortestPaths(ShortestPathsDag shortestPathsDag) {

        assert shortestPathsDag.hasPathTo(0);
        assert shortestPathsDag.hasPathTo(1);
        assert shortestPathsDag.hasPathTo(2);
        assert shortestPathsDag.hasPathTo(3);
        assert shortestPathsDag.hasPathTo(4);
        assert shortestPathsDag.hasPathTo(5);
        assert shortestPathsDag.hasPathTo(6);
        assert shortestPathsDag.hasPathTo(7);

        assert shortestPathsDag.distTo(0) == 0.73;
        assert shortestPathsDag.distTo(1) == 0.32;
        assert shortestPathsDag.distTo(2) == 0.62;
        assert shortestPathsDag.distTo(3) == 0.61;
        assert shortestPathsDag.distTo(4) == 0.35;
        assert shortestPathsDag.distTo(5) == 0.00;
        assert shortestPathsDag.distTo(6) == 1.13;
        assert shortestPathsDag.distTo(7) == 0.28;

        testPath(0, shortestPathsDag, new EdgeWeightedDigraph.DirectedEdge[]{
                new EdgeWeightedDigraph.DirectedEdge(5, 4, 0.35),
                new EdgeWeightedDigraph.DirectedEdge(4, 0, 0.38),
        });

        testPath(1, shortestPathsDag, new EdgeWeightedDigraph.DirectedEdge[]{
                new EdgeWeightedDigraph.DirectedEdge(5, 1, 0.32),
        });

        testPath(2, shortestPathsDag, new EdgeWeightedDigraph.DirectedEdge[]{
                new EdgeWeightedDigraph.DirectedEdge(5, 7, 0.28),
                new EdgeWeightedDigraph.DirectedEdge(7, 2, 0.34),
        });

        testPath(3, shortestPathsDag, new EdgeWeightedDigraph.DirectedEdge[]{
                new EdgeWeightedDigraph.DirectedEdge(5, 1, 0.32),
                new EdgeWeightedDigraph.DirectedEdge(1, 3, 0.29),
        });

        testPath(4, shortestPathsDag, new EdgeWeightedDigraph.DirectedEdge[]{
                new EdgeWeightedDigraph.DirectedEdge(5, 4, 0.35),
        });

        testPath(5, shortestPathsDag, new EdgeWeightedDigraph.DirectedEdge[]{
        });

        testPath(6, shortestPathsDag, new EdgeWeightedDigraph.DirectedEdge[]{
                new EdgeWeightedDigraph.DirectedEdge(5, 1, 0.32),
                new EdgeWeightedDigraph.DirectedEdge(1, 3, 0.29),
                new EdgeWeightedDigraph.DirectedEdge(3, 6, 0.52),
        });

        testPath(7, shortestPathsDag, new EdgeWeightedDigraph.DirectedEdge[]{
                new EdgeWeightedDigraph.DirectedEdge(5, 7, 0.32),
        });
    }

    private static void testPath(int v, ShortestPathsDag shortestPathsDag, EdgeWeightedDigraph.DirectedEdge[] edges) {

        int i = 0;
        for (EdgeWeightedDigraph.DirectedEdge edge : shortestPathsDag.pathTo(v)) {
            assert edges[i].toString().equals(edge.toString());
            i++;
        }
    }
}
