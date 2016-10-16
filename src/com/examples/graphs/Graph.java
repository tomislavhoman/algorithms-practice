package com.examples.graphs;

import com.examples.basic.Bag;
import com.examples.basic.LinkedListBag;

public class Graph {

    private final int V;
    private int E;

    private Bag<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int v) {
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

    public void addEdge(int v, int w) {

        adj[v].add(w);
        adj[w].add(v);

        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }
}
