package com.examples.algorithms.graphs.iterator;

import com.examples.algorithms.graphs.EdgeWeightedDigraph;

import java.util.Iterator;

public class DirectedEdgeToVertexIterator implements Iterator<Integer> {

    private final Iterator<EdgeWeightedDigraph.DirectedEdge> edgesIterator;

    public DirectedEdgeToVertexIterator(Iterable<EdgeWeightedDigraph.DirectedEdge> edges) {
        this.edgesIterator = edges.iterator();
    }

    @Override
    public boolean hasNext() {
        return edgesIterator.hasNext();
    }

    @Override
    public Integer next() {
        return edgesIterator.next().to();
    }
}
