package com.examples.algorithms.sorting;

public class MaxPriorityQueueTest {

    public static void main(String[] args) {

        MaxPriorityQueue<Integer> maxPriorityQueue = new HeapMaxPriorityQueue<>(8);

        assert maxPriorityQueue.isEmpty();
        assert maxPriorityQueue.size() == 0;

        maxPriorityQueue.insert(10);
        assert !maxPriorityQueue.isEmpty();
        assert maxPriorityQueue.size() == 1;
        assert maxPriorityQueue.max() == 10;

        maxPriorityQueue.insert(5);
        assert maxPriorityQueue.size() == 2;
        assert maxPriorityQueue.max() == 10;

        maxPriorityQueue.insert(7);
        assert maxPriorityQueue.size() == 3;
        assert maxPriorityQueue.max() == 10;

        maxPriorityQueue.insert(11);
        assert maxPriorityQueue.size() == 4;
        assert maxPriorityQueue.max() == 11;

        maxPriorityQueue.insert(15);
        assert maxPriorityQueue.size() == 5;
        assert maxPriorityQueue.max() == 15;

        maxPriorityQueue.insert(6);
        assert maxPriorityQueue.size() == 6;
        assert maxPriorityQueue.max() == 15;

        maxPriorityQueue.insert(9);
        assert maxPriorityQueue.size() == 7;
        assert maxPriorityQueue.max() == 15;

        maxPriorityQueue.insert(20);
        assert maxPriorityQueue.size() == 8;
        assert maxPriorityQueue.max() == 20;

        assert maxPriorityQueue.removeMax() == 20;
        assert maxPriorityQueue.removeMax() == 15;
        assert maxPriorityQueue.removeMax() == 11;
        assert maxPriorityQueue.removeMax() == 10;
        assert maxPriorityQueue.removeMax() == 9;
        assert maxPriorityQueue.removeMax() == 7;
        assert maxPriorityQueue.removeMax() == 6;
        assert maxPriorityQueue.removeMax() == 5;

        assert maxPriorityQueue.isEmpty();

        System.out.println("all ok");
    }
}
