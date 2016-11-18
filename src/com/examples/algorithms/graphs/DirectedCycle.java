package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedStack;
import com.examples.algorithms.basic.Stack;
import com.examples.algorithms.graphs.iterator.AdjacencyIterator;
import com.examples.algorithms.graphs.iterator.DigraphAdjacencyIterator;
import com.examples.algorithms.graphs.iterator.EdgeWeightedDigraphAdjacencyIterator;

public class DirectedCycle {

    private final boolean[] marked;
    private final int[] edgeTo;
    private final boolean[] onStack;

    private Iterable<Integer> cycle;

    public DirectedCycle(Digraph digraph) {
        this(digraph.v(), new DigraphAdjacencyIterator(digraph));
    }

    public DirectedCycle(EdgeWeightedDigraph digraph) {
        this(digraph.v(), new EdgeWeightedDigraphAdjacencyIterator(digraph));
    }

    private DirectedCycle(int numberOfVertices, AdjacencyIterator adjacencyIterator) {

        this.marked = new boolean[numberOfVertices];
        this.edgeTo = new int[numberOfVertices];
        this.onStack = new boolean[numberOfVertices];

        for (int v = 0; v < numberOfVertices; v++) {
            this.edgeTo[v] = v;
        }

        for (int v = 0; v < numberOfVertices; v++) {
            if (!this.marked[v]) {
                dfs(v, adjacencyIterator);
            }
        }
    }

    private void dfs(int v, AdjacencyIterator adjacencyIterator) {

        marked[v] = true;
        onStack[v] = true;

        for (int w : adjacencyIterator.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(w, adjacencyIterator);
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
