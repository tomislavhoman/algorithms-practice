package com.examples.algorithms.graphs.iterator;

import com.examples.algorithms.graphs.EdgeWeightedDigraph;

public class EdgeWeightedDigraphAdjacencyIterator implements AdjacencyIterator {

    private final EdgeWeightedDigraph edgeWeightedDigraph;

    public EdgeWeightedDigraphAdjacencyIterator(EdgeWeightedDigraph edgeWeightedDigraph) {
        this.edgeWeightedDigraph = edgeWeightedDigraph;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return new DirectedEdgeToVertexIterable(edgeWeightedDigraph.adj(v));
    }
}
