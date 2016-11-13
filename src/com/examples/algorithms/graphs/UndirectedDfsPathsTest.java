package com.examples.algorithms.graphs;

public class UndirectedDfsPathsTest {

    public static void main(String[] args) {

        Graph graph = loadGraph();
        testPaths(new UndirectedDfsPaths(graph, 0));
        System.out.println("All OK");
    }

    private static Graph loadGraph() {

        Graph graph = new Graph(8);
        graph.addEdge(0, 5);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(0, 2);
        graph.addEdge(6, 7);
        return graph;
    }

    private static void testPaths(UndirectedDfsPaths paths) {

        assert paths.hasPathTo(0);
        assert paths.hasPathTo(1);
        assert paths.hasPathTo(2);
        assert paths.hasPathTo(3);
        assert paths.hasPathTo(4);
        assert paths.hasPathTo(5);
        assert !paths.hasPathTo(6);
        assert !paths.hasPathTo(7);

        testPath(paths, 0, new int[]{0});
        testPath(paths, 1, new int[]{0, 2, 1});
        testPath(paths, 2, new int[]{0, 2});
        testPath(paths, 3, new int[]{0, 2, 3});
        testPath(paths, 4, new int[]{0, 2, 3, 4});
        testPath(paths, 5, new int[]{0, 2, 3, 5});
    }

    private static void testPath(UndirectedDfsPaths paths, int v, int[] vertices) {

        int i = 0;
        for (int w : paths.pathTo(v)) {
            assert w == vertices[i] : "Failed on path to " + v;
            i++;
        }
    }
}
