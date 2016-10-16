package com.examples.graphs;

import com.examples.basic.LinkedStack;
import com.examples.basic.Stack;

public class UndirectedDfsPaths {

    private final int s;

    private boolean marked[];
    private int edgeTo[];

    public UndirectedDfsPaths(Graph graph, int s) {

        this.s = s;
        this.marked = new boolean[graph.v()];
        this.edgeTo = new int[graph.v()];
        for (int i = 0, v = graph.v(); i < v; i++) {
            this.edgeTo[i] = i;
        }

        this.marked[s] = true;
        this.edgeTo[s] = s;
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {

        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    boolean hasPathTo(int v) {
        return marked[v];
    }

    Iterable<Integer> pathTo(int v) {

        Stack<Integer> stack = new LinkedStack<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }
}
