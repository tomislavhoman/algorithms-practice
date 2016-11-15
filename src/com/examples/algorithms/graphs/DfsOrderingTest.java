package com.examples.algorithms.graphs;

public class DfsOrderingTest {

    public static void main(String[] args) {
        testOrdering(new DfsOrdering(loadDigraph()));
        System.out.println("all ok!!!");
    }

    private static Digraph loadDigraph() {

        Digraph digraph = new Digraph(13);
        digraph.addEdge(2, 3);
        digraph.addEdge(0, 6);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 0);
        digraph.addEdge(11, 12);
        digraph.addEdge(9, 12);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(3, 5);
        digraph.addEdge(8, 7);
        digraph.addEdge(5, 4);
        digraph.addEdge(0, 5);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 9);
        digraph.addEdge(7, 6);
        return digraph;
    }

    private static void testOrdering(DfsOrdering dfsOrdering) {
        testPreorder(dfsOrdering, new int[]{0, 5, 4, 1, 6, 9, 11, 12, 10, 2, 3, 7, 8});
        testPostorder(dfsOrdering, new int[]{4, 5, 1, 12, 11, 10, 9, 6, 0, 3, 2, 7, 8});
        testReversePostorder(dfsOrdering, new int[]{8, 7, 2, 3, 0, 6, 9, 10, 11, 12, 1, 5, 4});
    }

    private static void testPreorder(DfsOrdering dfsOrdering, int[] preorder) {
        testPath(dfsOrdering.preorder(), preorder);
    }

    private static void testPostorder(DfsOrdering dfsOrdering, int[] postorder) {
        testPath(dfsOrdering.postorder(), postorder);
    }

    private static void testReversePostorder(DfsOrdering dfsOrdering, int[] reversePostorder) {
        testPath(dfsOrdering.reversePostorder(), reversePostorder);
    }

    private static void testPath(Iterable<Integer> givenPath, int[] expectedPath) {
        int i = 0;
        for (int v : givenPath) {
            assert v == expectedPath[i];
            i++;
        }
    }
}
