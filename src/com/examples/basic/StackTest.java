package com.examples.basic;

public class StackTest {

    public static void main(String[] args) {

        test(new Stack<Integer>() {
            @Override
            public void push(Integer integer) {

            }

            @Override
            public Integer pop() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        });
    }

    private static void test(Stack<Integer> stack) {

        assert stack.isEmpty() : "Should be empty";

        stack.push(7);

        assert !stack.isEmpty() : "Should not be empty";

        stack.push(5);
        stack.push(4);

        assert stack.pop() == 4 : "Should be 4";
        assert stack.pop() == 5 : "Should be 5";
        assert stack.pop() == 7 : "Should be 7";

        assert stack.isEmpty() : "Should be empty";
    }
}
