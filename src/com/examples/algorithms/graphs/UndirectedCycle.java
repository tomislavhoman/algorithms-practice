package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedStack;
import com.examples.algorithms.basic.Stack;

public class UndirectedCycle {

    private final boolean[] marked;
    private final int[] edgeTo;

    private Iterable<Integer> cycle = null;
    private int s = 0;

    public UndirectedCycle(Graph graph) {

        this.marked = new boolean[graph.v()];
        this.edgeTo = new int[graph.v()];

        for (int v = 0; v < graph.v(); v++) {
            edgeTo[v] = v;
        }

        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {

        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (w != edgeTo[v] && !hasCycle()) {
                Stack<Integer> stack = new LinkedStack<>();
                stack.push(w);
                stack.push(v);
                while (v != s) {
                    v = edgeTo[v];
                    stack.push(v);
                }
                cycle = stack;
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
