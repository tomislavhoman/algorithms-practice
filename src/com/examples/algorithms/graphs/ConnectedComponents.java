package com.examples.algorithms.graphs;

public class ConnectedComponents {

    private final boolean marked[];
    private final int id[];

    private int currentId;

    public ConnectedComponents(Graph graph) {

        this.marked = new boolean[graph.v()];
        this.id = new int[graph.v()];
        this.currentId = 0;

        for (int v = 0; v < graph.v(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
                currentId++;
            }
        }
    }

    private void dfs(Graph graph, int v) {

        marked[v] = true;
        id[v] = currentId;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                id[w] = currentId;
                dfs(graph, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id(v) == id(w);
    }

    public int count() {
        return currentId;
    }

    public int id(int v) {
        return id[v];
    }
}
