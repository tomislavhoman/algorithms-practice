package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedQueue;
import com.examples.algorithms.basic.LinkedStack;
import com.examples.algorithms.basic.Queue;
import com.examples.algorithms.basic.Stack;

public class DirectedBfsPaths {

    private final int s;

    private final boolean[] marked;
    private final int[] edgeTo;
    private final int[] distTo;

    public DirectedBfsPaths(Digraph digraph, int s) {
        this.s = s;

        this.marked = new boolean[digraph.v()];
        this.edgeTo = new int[digraph.v()];
        this.distTo = new int[digraph.v()];

        for (int i = 0, v = digraph.v(); i < v; i++) {
            this.edgeTo[i] = i;
            this.distTo[i] = Integer.MAX_VALUE;
        }

        this.distTo[s] = 0;

        bfs(digraph, s);
    }

    private void bfs(Digraph digraph, int s) {

        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(s);
        marked[s] = true;

        while (!queue.isEmpty()) {

            int v = queue.dequeue();

            for (int w : digraph.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    queue.enqueue(w);
                }
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

    public int distTo(int v) {
        return distTo[v];
    }
}
