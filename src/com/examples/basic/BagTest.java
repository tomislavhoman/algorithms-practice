package com.examples.basic;

public class BagTest {

    public static void main(String[] args) {

        testBag(new LinkedListBag<>());
        System.out.println("all OK");
    }

    private static void testBag(Bag<Integer> bag) {

        assert bag.isEmpty();
        assert bag.size() == 0;

        bag.add(1);

        assert !bag.isEmpty();
        assert bag.size() == 1;

        for (int i = 2; i < 20; i++) {
            bag.add(i);
        }

        assert bag.size() == 19;

        int i = 19;
        for (int item : bag) {
            assert item == i;
            i--;
        }
    }
}
