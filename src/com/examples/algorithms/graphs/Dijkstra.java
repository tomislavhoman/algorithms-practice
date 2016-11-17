package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedStack;
import com.examples.algorithms.basic.Stack;
import com.examples.algorithms.sorting.HeapMinPriorityQueue;
import com.examples.algorithms.sorting.MinPriorityQueue;

public class Dijkstra {

    private EdgeWeightedDigraph.DirectedEdge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;

    public Dijkstra(EdgeWeightedDigraph digraph, int s) {

        this.edgeTo = new EdgeWeightedDigraph.DirectedEdge[digraph.v()];
        this.distTo = new double[digraph.v()];
        this.marked = new boolean[digraph.v()];
        for (int v = 0; v < digraph.v(); v++) {
            this.distTo[v] = Double.POSITIVE_INFINITY;
        }
        this.distTo[s] = 0.00;

        MinPriorityQueue<PriorityQueueNode> priorityQueue = new HeapMinPriorityQueue<>(100 * digraph.v());
        priorityQueue.insert(new PriorityQueueNode(0.00, s));

        while (!priorityQueue.isEmpty()) {
            PriorityQueueNode node = priorityQueue.removeMin();
            if (!marked[node.v]) {
                marked[node.v] = true;
                visit(node.v, priorityQueue, digraph);
            }
        }

    }

    private void visit(int v, MinPriorityQueue<PriorityQueueNode> priorityQueue, EdgeWeightedDigraph digraph) {
        for (EdgeWeightedDigraph.DirectedEdge edge : digraph.adj(v)) {
            if (!marked[edge.to()]) {
                relax(edge);
                priorityQueue.insert(new PriorityQueueNode(distTo[edge.to()], edge.to()));
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

    private static class PriorityQueueNode implements Comparable<PriorityQueueNode> {
        private double distance;
        private int v;

        public PriorityQueueNode(double distance, int v) {
            this.distance = distance;
            this.v = v;
        }

        @Override
        public int compareTo(PriorityQueueNode other) {
            return Double.compare(this.distance, other.distance);
        }
    }
}
