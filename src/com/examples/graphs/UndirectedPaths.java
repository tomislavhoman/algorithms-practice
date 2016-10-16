package com.examples.graphs;

import com.examples.basic.LinkedStack;
import com.examples.basic.Stack;

public class UndirectedPaths {

    private final int s;

    private boolean marked[];
    private Integer edgeTo[];

    public UndirectedPaths(Graph graph, int s) {

        this.s = s;
        this.marked = new boolean[graph.v()];
        this.edgeTo = new Integer[graph.v()];
        for (int i = 0, v = graph.v(); i < v; i++) {
            this.edgeTo[i] = i;
        }

        this.marked[s] = true;
        this.edgeTo[s] = null;
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
        for (Integer w = v; w != null; w = edgeTo[w]) {
            stack.push(w);
        }
        return stack;
    }
}
