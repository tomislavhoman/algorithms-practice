package com.examples.algorithms.graphs;

public class BipartiteGraph {

    private final boolean[] marked;
    private final boolean[] color;

    private boolean isBipartite = true;

    public BipartiteGraph(Graph graph) {

        this.marked = new boolean[graph.v()];
        this.color = new boolean[graph.v()];

        for (int v = 0; v < graph.v(); v++) {
            if (!marked[v]) {
                dfs(graph, 0);
            }
        }
    }

    private void dfs(Graph graph, int v) {

        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(graph, w);
            } else if (color[v] == color[w]) {
                isBipartite = false;
            }
        }
    }

    public boolean isBipartite() {
        return isBipartite;
    }
}
