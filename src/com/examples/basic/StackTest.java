package com.examples.basic;

public class StackTest {

    public static void main(String[] args) {

        test(new ResizableArrayStack<>());
        test(new LinkedStack<>());
    }

    private static void test(Stack<Integer> stack) {

        assert stack.isEmpty() : "Should be empty";

        stack.push(7);

        assert !stack.isEmpty() : "Should not be empty";

        stack.push(5);
        stack.push(4);
        stack.push(44);
        stack.push(45);
        stack.push(46);
        stack.push(47);

        assert stack.pop() == 47 : "Should be 47";
        assert stack.pop() == 46 : "Should be 46";
        assert stack.pop() == 45 : "Should be 45";
        assert stack.pop() == 44 : "Should be 44";
        assert stack.pop() == 4 : "Should be 4";
        assert stack.pop() == 5 : "Should be 5";
        assert stack.pop() == 7 : "Should be 7";

        assert stack.isEmpty() : "Should be empty";
    }
}
