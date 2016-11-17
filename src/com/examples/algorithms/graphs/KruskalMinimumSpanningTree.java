package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedQueue;
import com.examples.algorithms.basic.Queue;
import com.examples.algorithms.basic.UnionFind;
import com.examples.algorithms.basic.WeightedQuickUnionUnionFind;
import com.examples.algorithms.sorting.HeapMinPriorityQueue;
import com.examples.algorithms.sorting.MinPriorityQueue;

public class KruskalMinimumSpanningTree {

    private Queue<EdgeWeightedGraph.Edge> edges;
    private double weight;

    public KruskalMinimumSpanningTree(EdgeWeightedGraph edgeWeightedGraph) {

        this.edges = new LinkedQueue<>();

        UnionFind unionFind = new WeightedQuickUnionUnionFind(edgeWeightedGraph.v());

        MinPriorityQueue<EdgeWeightedGraph.Edge> minQueue = new HeapMinPriorityQueue<>(edgeWeightedGraph.e());
        for (EdgeWeightedGraph.Edge edge : edgeWeightedGraph.edges()) {
            minQueue.insert(edge);
        }

        while (!minQueue.isEmpty()) {
            EdgeWeightedGraph.Edge edge = minQueue.removeMin();
            int v = edge.either();
            int w = edge.other(v);
            if (!unionFind.connected(v, w)) {
                this.edges.enqueue(edge);
                unionFind.union(v, w);
                this.weight += edge.weight();
            }
        }
    }

    public Iterable<EdgeWeightedGraph.Edge> edges() {
        return edges;
    }

    public double weight() {
        return weight;
    }
}
