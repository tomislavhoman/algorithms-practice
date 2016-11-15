package com.examples.algorithms.graphs;

public class StronglyConnectedComponents {

    private final boolean[] marked;
    private final int id[];

    private int componentCount;

    public StronglyConnectedComponents(Digraph digraph) {

        this.marked = new boolean[digraph.v()];
        this.id = new int[digraph.v()];

        for (int v = 0; v < digraph.v(); v++) {
            this.id[v] = v;
        }

        for (int v : (new DfsOrdering(digraph.reverse())).reversePostorder()) {
            if (!this.marked[v]) {
                dfs(v, digraph);
                componentCount++;
            }
        }
    }

    private void dfs(int v, Digraph digraph) {

        marked[v] = true;
        id[v] = componentCount;

        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(w, digraph);
            }
        }
    }

    public int count() {
        return componentCount;
    }

    public int id(int v) {
        return id[v];
    }

    public boolean stronglyConnected(int v, int w) {
        return id(v) == id(w);
    }
}
