package com.examples.algorithms.graphs;

public class DirectedBfsPathsTest {

    public static void main(String[] args) {
        Digraph digraph = loadDigraph();
        testPaths(new DirectedBfsPaths(digraph, 0));
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

    private static void testPaths(DirectedBfsPaths paths) {
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

        assert paths.distTo(0) == 0;
        assert paths.distTo(1) == 1;
        assert paths.distTo(2) == 3;
        assert paths.distTo(3) == 3;
        assert paths.distTo(4) == 2;
        assert paths.distTo(5) == 1;
        assert paths.distTo(6) == Integer.MAX_VALUE;
        assert paths.distTo(7) == Integer.MAX_VALUE;
        assert paths.distTo(8) == Integer.MAX_VALUE;
        assert paths.distTo(9) == Integer.MAX_VALUE;
        assert paths.distTo(10) == Integer.MAX_VALUE;
        assert paths.distTo(11) == Integer.MAX_VALUE;
        assert paths.distTo(12) == Integer.MAX_VALUE;

        testPath(paths, 0, new int[]{0});
        testPath(paths, 1, new int[]{0, 1});
        testPath(paths, 2, new int[]{0, 5, 4, 2});
        testPath(paths, 3, new int[]{0, 5, 4, 3});
        testPath(paths, 4, new int[]{0, 5, 4});
        testPath(paths, 5, new int[]{0, 5});
    }

    private static void testPath(DirectedBfsPaths paths, int v, int[] vertices) {

        int i = 0;
        for (int w : paths.pathTo(v)) {
            assert w == vertices[i] : "Failed on path to " + v;
            i++;
        }
    }
}
