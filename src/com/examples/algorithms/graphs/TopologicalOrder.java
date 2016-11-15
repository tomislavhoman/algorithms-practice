package com.examples.algorithms.graphs;

public class TopologicalOrder {

    private Iterable<Integer> order;

    public TopologicalOrder(Digraph digraph) {

        if (!(new DirectedCycle(digraph).hasCycle())) {
            this.order = new DfsOrdering(digraph).reversePostorder();
        }
    }

    public boolean isDAG() {
        return order != null;
    }

    public Iterable<Integer> order() {
        return order;
    }
}
