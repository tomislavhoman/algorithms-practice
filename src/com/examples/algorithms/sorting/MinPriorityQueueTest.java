package com.examples.algorithms.sorting;

public class MinPriorityQueueTest {

    public static void main(String[] args) {

        MinPriorityQueue<Integer> minPriorityQueue = new HeapMinPriorityQueue<>(8);

        assert minPriorityQueue.isEmpty();
        assert minPriorityQueue.size() == 0;

        minPriorityQueue.insert(10);
        assert !minPriorityQueue.isEmpty();
        assert minPriorityQueue.size() == 1;
        assert minPriorityQueue.min() == 10;

        minPriorityQueue.insert(11);
        assert minPriorityQueue.size() == 2;
        assert minPriorityQueue.min() == 10;

        minPriorityQueue.insert(7);
        assert minPriorityQueue.size() == 3;
        assert minPriorityQueue.min() == 7;

        minPriorityQueue.insert(15);
        assert minPriorityQueue.size() == 4;
        assert minPriorityQueue.min() == 7;

        minPriorityQueue.insert(6);
        assert minPriorityQueue.size() == 5;
        assert minPriorityQueue.min() == 6;

        minPriorityQueue.insert(5);
        assert minPriorityQueue.size() == 6;
        assert minPriorityQueue.min() == 5;

        minPriorityQueue.insert(9);
        assert minPriorityQueue.size() == 7;
        assert minPriorityQueue.min() == 5;

        minPriorityQueue.insert(20);
        assert minPriorityQueue.size() == 8;
        assert minPriorityQueue.min() == 5;

        assert minPriorityQueue.removeMin() == 5;
        assert minPriorityQueue.removeMin() == 6;
        assert minPriorityQueue.removeMin() == 7;
        assert minPriorityQueue.removeMin() == 9;
        assert minPriorityQueue.removeMin() == 10;
        assert minPriorityQueue.removeMin() == 11;
        assert minPriorityQueue.removeMin() == 15;
        assert minPriorityQueue.removeMin() == 20;

        assert minPriorityQueue.isEmpty();

        System.out.println("all ok!");
    }
}
