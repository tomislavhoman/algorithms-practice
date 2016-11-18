package com.examples.algorithms.graphs.iterator;

import com.examples.algorithms.graphs.EdgeWeightedDigraph;

import java.util.Iterator;

public class DirectedEdgeToVertexIterable implements Iterable<Integer> {

    private final Iterable<EdgeWeightedDigraph.DirectedEdge> edges;

    public DirectedEdgeToVertexIterable(Iterable<EdgeWeightedDigraph.DirectedEdge> edges) {
        this.edges = edges;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new DirectedEdgeToVertexIterator(edges);
    }
}
