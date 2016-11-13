package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedStack;
import com.examples.algorithms.basic.Stack;

public class DirectedDfsPaths {

    private final int s;

    private final boolean[] marked;
    private final int[] edgeTo;

    public DirectedDfsPaths(Digraph digraph, int s) {

        this.s = s;
        this.marked = new boolean[digraph.v()];
        this.edgeTo = new int[digraph.v()];
        for (int i = 0, v = digraph.v(); i < v; i++) {
            this.edgeTo[i] = i;
        }

        dfs(digraph, s);
    }

    private void dfs(Digraph digraph, int v) {

        marked[v] = true;
        for (int w : digraph.adj(v)) {

            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {

        Stack<Integer> stack = new LinkedStack<>();
        while (v != s) {
            stack.push(v);
            v = edgeTo[v];
        }
        stack.push(s);

        return stack;
    }
}
