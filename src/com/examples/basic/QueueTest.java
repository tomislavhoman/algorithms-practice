package com.examples.basic;

public class QueueTest {

    public static void main(String[] args) {

        test(new ResizableArrayQueue<>());
        test(new LinkedQueue<>());
    }

    private static void test(Queue<Integer> queue) {

        assert queue.isEmpty() : "Should be empty";

        queue.enqueue(1);
        assert !queue.isEmpty() : "Shouldn't be empty";

        queue.enqueue(6);
        queue.enqueue(5);

        assert queue.dequeue() == 1 : "Should be 1";
        assert queue.dequeue() == 6 : "Should be 6";
        assert queue.dequeue() == 5 : "Should be 5";

        queue.enqueue(1);
        queue.enqueue(6);
        queue.enqueue(5);
        queue.enqueue(44);
        queue.enqueue(33);
        queue.enqueue(42);
        queue.enqueue(7);
        queue.enqueue(2);

        assert queue.dequeue() == 1 : "Should be 1";
        assert queue.dequeue() == 6 : "Should be 6";
        assert queue.dequeue() == 5 : "Should be 5";
        assert queue.dequeue() == 44 : "Should be 44";
        assert queue.dequeue() == 33 : "Should be 33";
        assert queue.dequeue() == 42 : "Should be 42";
        assert queue.dequeue() == 7 : "Should be 7";
        assert queue.dequeue() == 2 : "Should be 2";

        assert queue.isEmpty() : "Should be empty";
    }
}
