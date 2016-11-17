package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedQueue;
import com.examples.algorithms.basic.Queue;
import com.examples.algorithms.sorting.HeapMinPriorityQueue;
import com.examples.algorithms.sorting.MinPriorityQueue;

public class PrimMinimumSpanningTree {

    private Queue<EdgeWeightedGraph.Edge> edges;
    private double weight;

    public PrimMinimumSpanningTree(EdgeWeightedGraph edgeWeightedGraph) {

        this.edges = new LinkedQueue<>();

        boolean[] inMST = new boolean[edgeWeightedGraph.v()];

        int s = 0;
        MinPriorityQueue<EdgeWeightedGraph.Edge> front = new HeapMinPriorityQueue<>(10 * edgeWeightedGraph.e());
        for (EdgeWeightedGraph.Edge edge : edgeWeightedGraph.adj(s)) {
            front.insert(edge);
        }
        inMST[s] = true;

        int i = 0;
        while (i < edgeWeightedGraph.v() - 1) {
            EdgeWeightedGraph.Edge edge = front.removeMin();
            int v = edge.either();
            int w = edge.other(v);

            if (inMST[v] && inMST[w]) {
                continue;
            }

            int newV;
            if (!inMST[v]) {
                newV = v;
            } else {
                newV = w;
            }

            inMST[newV] = true;
            edges.enqueue(edge);
            for (EdgeWeightedGraph.Edge newEdge : edgeWeightedGraph.adj(newV)) {
                if (!inMST[newEdge.other(newV)]) {
                    front.insert(newEdge);
                }
            }
            weight += edge.weight();
            i++;
        }

    }

    public Iterable<EdgeWeightedGraph.Edge> edges() {
        return edges;
    }

    public double weight() {
        return weight;
    }
}
