package com.examples.algorithms.graphs.iterator;

import com.examples.algorithms.graphs.Digraph;

public class DigraphAdjacencyIterator implements AdjacencyIterator {

    private final Digraph digraph;

    public DigraphAdjacencyIterator(Digraph digraph) {
        this.digraph = digraph;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return digraph.adj(v);
    }
}
