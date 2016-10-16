package com.examples.graphs;

import com.examples.basic.Bag;
import com.examples.basic.LinkedListBag;

public class Digraph {

    private final int V;
    private int E;

    private Bag<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Digraph(int v) {
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
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {

        Digraph digraph = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                digraph.addEdge(w, v);
            }
        }
        return digraph;
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
