package com.examples.graphs;

import com.examples.basic.Bag;
import com.examples.basic.LinkedListBag;

public class EdgeWeightedDigraph {

    private final int V;
    private int E;

    private Bag<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int v) {
        this.V = v;
        this.adj = new Bag[v];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedListBag<>();
        }
    }

    public int v() {
        return V;
    }

    public int e() {
        return E;
    }

    public void addEdge(DirectedEdge edge) {
        adj[edge.from].add(edge);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {

        Bag<DirectedEdge> edges = new LinkedListBag<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge edge : adj(v)) {
                edges.add(edge);
            }
        }
        return edges;
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (DirectedEdge e : this.adj(v))
                s += e + " ";
            s += "\n";
        }
        return s;
    }

    public static class DirectedEdge implements Comparable<DirectedEdge> {

        private int from;
        private int to;
        private double weight;

        public DirectedEdge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int from() {
            return from;
        }

        public int to() {
            return to;
        }

        public double weight() {
            return weight;
        }

        @Override
        public int compareTo(DirectedEdge that) {

            if (this.weight < that.weight) {
                return -1;
            } else if (this.weight > that.weight) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return String.format("%d->%d %.2f", from, to, weight);
        }
    }
}
