package com.examples.algorithms.graphs;

public class ConnectedComponentsTest {

    public static void main(String[] args) {

        Graph graph = loadGraph();
        testConnectedComponents(new ConnectedComponents(graph));
        System.out.println("All ok");
    }

    private static Graph loadGraph() {

        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
        return graph;
    }

    private static void testConnectedComponents(ConnectedComponents connectedComponents) {

        assert connectedComponents.count() == 3;

        assert connectedComponents.id(0) == 0;
        assert connectedComponents.id(1) == 0;
        assert connectedComponents.id(2) == 0;
        assert connectedComponents.id(3) == 0;
        assert connectedComponents.id(4) == 0;
        assert connectedComponents.id(5) == 0;
        assert connectedComponents.id(6) == 0;

        assert connectedComponents.id(7) == 1;
        assert connectedComponents.id(8) == 1;

        assert connectedComponents.id(9) == 2;
        assert connectedComponents.id(10) == 2;
        assert connectedComponents.id(11) == 2;
        assert connectedComponents.id(12) == 2;

        assert connectedComponents.connected(0, 0);
        assert connectedComponents.connected(0, 1);
        assert connectedComponents.connected(0, 2);
        assert connectedComponents.connected(0, 3);
        assert connectedComponents.connected(0, 4);
        assert connectedComponents.connected(0, 5);
        assert connectedComponents.connected(0, 6);

        assert !connectedComponents.connected(0, 7);
        assert !connectedComponents.connected(0, 8);
        assert !connectedComponents.connected(0, 9);
        assert !connectedComponents.connected(0, 10);
        assert !connectedComponents.connected(0, 11);
        assert !connectedComponents.connected(0, 12);
    }
}
