package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedStack;
import com.examples.algorithms.basic.Stack;

public class DirectedCycle {

    private final boolean[] marked;
    private final int[] edgeTo;
    private final boolean[] onStack;

    private Iterable<Integer> cycle;

    public DirectedCycle(Digraph digraph) {

        this.marked = new boolean[digraph.v()];
        this.edgeTo = new int[digraph.v()];
        this.onStack = new boolean[digraph.v()];

        for (int v = 0; v < digraph.v(); v++) {
            this.edgeTo[v] = v;
        }

        for (int v = 0; v < digraph.v(); v++) {
            if (!this.marked[v]) {
                dfs(v, digraph);
            }
        }
    }

    private void dfs(int v, Digraph digraph) {

        marked[v] = true;
        onStack[v] = true;

        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(w, digraph);
            } else if (edgeTo[w] != v && onStack[w] && !hasCycle()) {
                Stack<Integer> stack = new LinkedStack<>();
                stack.push(w);
                stack.push(v);
                int t = v;
                while (t != w) {
                    t = edgeTo[t];
                    stack.push(t);
                }
                cycle = stack;
            }
        }

        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
