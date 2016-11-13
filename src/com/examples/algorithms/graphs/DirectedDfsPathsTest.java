package com.examples.algorithms.graphs;

public class DirectedDfsPathsTest {

    public static void main(String[] args) {
        Digraph digraph = loadDigraph();
        testPaths(new DirectedDfsPaths(digraph, 0));
        System.out.println("All cool");
    }

    private static Digraph loadDigraph() {

        Digraph digraph = new Digraph(13);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 5);
        digraph.addEdge(2, 0);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(3, 5);
        digraph.addEdge(4, 2);
        digraph.addEdge(4, 3);
        digraph.addEdge(5, 4);
        digraph.addEdge(6, 0);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        digraph.addEdge(7, 8);
        digraph.addEdge(8, 7);
        digraph.addEdge(8, 9);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(10, 12);
        digraph.addEdge(11, 4);
        digraph.addEdge(11, 12);
        digraph.addEdge(12, 9);

        return digraph;
    }

    private static void testPaths(DirectedDfsPaths paths) {

        assert paths.hasPathTo(0);
        assert paths.hasPathTo(1);
        assert paths.hasPathTo(2);
        assert paths.hasPathTo(3);
        assert paths.hasPathTo(4);
        assert paths.hasPathTo(5);
        assert !paths.hasPathTo(6);
        assert !paths.hasPathTo(7);
        assert !paths.hasPathTo(8);
        assert !paths.hasPathTo(9);
        assert !paths.hasPathTo(10);
        assert !paths.hasPathTo(11);
        assert !paths.hasPathTo(12);

        testPath(paths, 0, new int[]{0});
        testPath(paths, 1, new int[]{0, 1});
        testPath(paths, 2, new int[]{0, 5, 4, 3, 2});
        testPath(paths, 3, new int[]{0, 5, 4, 3});
        testPath(paths, 4, new int[]{0, 5, 4});
        testPath(paths, 5, new int[]{0, 5});
    }

    private static void testPath(DirectedDfsPaths paths, int v, int[] vertices) {

        int i = 0;
        for (int w : paths.pathTo(v)) {
            assert w == vertices[i] : "Failed on path to " + v;
            i++;
        }
    }
}
