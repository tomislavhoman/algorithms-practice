package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedQueue;
import com.examples.algorithms.basic.LinkedStack;
import com.examples.algorithms.basic.Queue;
import com.examples.algorithms.basic.Stack;
import com.examples.algorithms.graphs.iterator.AdjacencyIterator;
import com.examples.algorithms.graphs.iterator.DigraphAdjacencyIterator;
import com.examples.algorithms.graphs.iterator.EdgeWeightedDigraphAdjacencyIterator;

public class DfsOrdering {

    private final boolean[] marked;
    private final Queue<Integer> preorder;
    private final Queue<Integer> postorder;
    private final Stack<Integer> reversePostorder;

    public DfsOrdering(EdgeWeightedDigraph digraph) {
        this(digraph.v(), new EdgeWeightedDigraphAdjacencyIterator(digraph));
    }

    public DfsOrdering(Digraph digraph) {
        this(digraph.v(), new DigraphAdjacencyIterator(digraph));
    }

    private DfsOrdering(int numberOfVertices, AdjacencyIterator adjacencyIterator) {

        this.marked = new boolean[numberOfVertices];
        this.preorder = new LinkedQueue<>();
        this.postorder = new LinkedQueue<>();
        this.reversePostorder = new LinkedStack<>();

        for (int v = 0; v < numberOfVertices; v++) {
            if (!marked[v]) {
                dfs(v, adjacencyIterator);
            }
        }
    }

    private void dfs(int v, AdjacencyIterator adjacencyIterator) {

        preorder.enqueue(v);

        marked[v] = true;
        for (int w : adjacencyIterator.adj(v)) {
            if (!marked[w]) {
                dfs(w, adjacencyIterator);
            }
        }

        postorder.enqueue(v);
        reversePostorder.push(v);
    }

    public Iterable<Integer> preorder() {
        return preorder;
    }

    public Iterable<Integer> postorder() {
        return postorder;
    }

    public Iterable<Integer> reversePostorder() {
        return reversePostorder;
    }
}
