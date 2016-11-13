package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.Bag;
import com.examples.algorithms.basic.LinkedListBag;

public class EdgeWeightedGraph {

    private final int V;
    private int E;

    private Bag<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int v) {
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

    public void addEdge(Edge edge) {

        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {

        Bag<Edge> edges = new LinkedListBag<>();
        for (int v = 0; v < V; v++) {
            for (Edge edge : adj(v)) {
                if (edge.other(v) > v) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (Edge e : this.adj(v))
                s += e + " ";
            s += "\n";
        }
        return s;
    }

    public static class Edge implements Comparable<Edge> {

        private int v;
        private int w;
        private double weight;

        public Edge(int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int either() {
            return v;
        }

        public int other(int t) {
            if (v == t) {
                return w;
            } else if (w == t) {
                return v;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public double weight() {
            return weight;
        }

        @Override
        public int compareTo(Edge that) {

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
            return String.format("%d-%d %.2f", v, w, weight);
        }
    }
}
