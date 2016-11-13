package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedQueue;
import com.examples.algorithms.basic.LinkedStack;
import com.examples.algorithms.basic.Queue;
import com.examples.algorithms.basic.Stack;

public class UndirectedBfsPaths {

    private final int s;

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public UndirectedBfsPaths(Graph graph, int s) {
        this.s = s;
        this.marked = new boolean[graph.v()];
        this.edgeTo = new int[graph.v()];
        this.distTo = new int[graph.v()];

        this.marked[s] = true;
        this.edgeTo[s] = s;

        for (int i = 0, v = graph.v(); i < v; i++) {
            this.edgeTo[i] = i;
            this.distTo[i] = Integer.MAX_VALUE;
        }

        this.distTo[s] = 0;

        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(s);

        while (!queue.isEmpty()) {

            int v = queue.dequeue();
            for (int w : graph.adj(v)) {
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
        for (int w = v; w != s; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }

    public int distTo(int v) {
        return distTo[v];
    }
}
