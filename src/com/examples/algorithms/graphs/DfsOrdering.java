package com.examples.algorithms.graphs;

import com.examples.algorithms.basic.LinkedQueue;
import com.examples.algorithms.basic.LinkedStack;
import com.examples.algorithms.basic.Queue;
import com.examples.algorithms.basic.Stack;

public class DfsOrdering {

    private final boolean[] marked;
    private final Queue<Integer> preorder;
    private final Queue<Integer> postorder;
    private final Stack<Integer> reversePostorder;

    public DfsOrdering(Digraph digraph) {

        this.marked = new boolean[digraph.v()];
        this.preorder = new LinkedQueue<>();
        this.postorder = new LinkedQueue<>();
        this.reversePostorder = new LinkedStack<>();

        for (int v = 0; v < digraph.v(); v++) {
            if (!marked[v]) {
                dfs(v, digraph);
            }
        }
    }

    private void dfs(int v, Digraph digraph) {

        preorder.enqueue(v);

        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(w, digraph);
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
