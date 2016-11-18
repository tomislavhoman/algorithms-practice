package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedStack;
import com.examples.algorithms.basic.Stack;

public class ShortestPathsDag {

    private final EdgeWeightedDigraph.DirectedEdge[] edgeTo;
    private final double[] distTo;
    private final boolean[] marked;

    public ShortestPathsDag(EdgeWeightedDigraph digraph, int s) {

        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if (directedCycle.hasCycle()) {
            throw new IllegalArgumentException("Digraph shouldn't have a cycle");
        }

        this.edgeTo = new EdgeWeightedDigraph.DirectedEdge[digraph.v()];
        this.distTo = new double[digraph.v()];
        this.marked = new boolean[digraph.v()];

        for (int v = 0; v < digraph.v(); v++) {
            this.distTo[v] = Double.POSITIVE_INFINITY;
        }
        this.distTo[s] = 0.00;

        TopologicalOrder topologicalOrder = new TopologicalOrder(digraph);
        for (int v : topologicalOrder.order()) {
            for (EdgeWeightedDigraph.DirectedEdge edge : digraph.adj(v)) {
                if (!this.marked[edge.to()]) {
                    relax(edge);
                    this.marked[edge.to()] = true;
                }
            }
        }
    }

    private void relax(EdgeWeightedDigraph.DirectedEdge edge) {
        double newDistance = roundTo2Decimals(distTo[edge.from()] + edge.weight());
        if (newDistance < distTo[edge.to()]) {
            distTo[edge.to()] = newDistance;
            edgeTo[edge.to()] = edge;
        }
    }

    private double roundTo2Decimals(double number) {
        return (double) Math.round(number * 100) / 100;
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<EdgeWeightedDigraph.DirectedEdge> pathTo(int v) {

        Stack<EdgeWeightedDigraph.DirectedEdge> path = new LinkedStack<>();
        EdgeWeightedDigraph.DirectedEdge edge = edgeTo[v];
        while (edge != null) {
            path.push(edge);
            edge = edgeTo[edge.from()];
        }
        return path;
    }
}
