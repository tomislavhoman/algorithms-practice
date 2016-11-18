package com.examples.algorithms.graphs;

public class TopologicalOrder {

    private Iterable<Integer> order;

    public TopologicalOrder(Digraph digraph) {
        this(new DirectedCycle(digraph), new DfsOrdering(digraph));
    }

    public TopologicalOrder(EdgeWeightedDigraph digraph) {
        this(new DirectedCycle(digraph), new DfsOrdering(digraph));
    }

    private TopologicalOrder(DirectedCycle directedCycle, DfsOrdering dfsOrdering) {

        if (!(directedCycle.hasCycle())) {
            this.order = dfsOrdering.reversePostorder();
        }
    }

    public boolean isDAG() {
        return order != null;
    }

    public Iterable<Integer> order() {
        return order;
    }
}
