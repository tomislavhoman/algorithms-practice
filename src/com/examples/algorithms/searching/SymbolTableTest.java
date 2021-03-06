package com.examples.algorithms.searching;

public class SymbolTableTest {

    public static void main(String[] args) {

        testSymbolTable(new SequentialSymbolTable<>());
        testSymbolTable(new BinarySearchSymbolTable<>());
        testSymbolTable(new BinarySearchTree<>());
        testSymbolTable(new RedBlackBinarySearchTree<>());
        inspectBalancedBSTHeight(new RedBlackBinarySearchTree<>());
        testSymbolTable(new SeparateChainingHashTable<>());
        testSymbolTable(new LinearProbingHashTable<>());
        System.out.println("All ok");
    }

    private static void testSymbolTable(SymbolTable<Integer, String> symbolTable) {

        assert symbolTable.isEmpty();

        symbolTable.put(42, "The answer");

        assert !symbolTable.isEmpty();
        assert symbolTable.size() == 1;

        symbolTable.put(3, "3");
        symbolTable.put(8, "8");
        symbolTable.put(888, "888");
        symbolTable.put(257, "257");
        symbolTable.put(16, "16");
        symbolTable.put(321, "323333");
        symbolTable.put(321, "321");

        assert symbolTable.size() == 7;

        assert symbolTable.get(42).equals("The answer");
        assert symbolTable.get(3).equals("3");
        assert symbolTable.get(8).equals("8");
        assert symbolTable.get(888).equals("888");
        assert symbolTable.get(257).equals("257");
        assert symbolTable.get(16).equals("16");
        assert symbolTable.get(321).equals("321");

        assert symbolTable.contains(42);
        assert !symbolTable.contains(55);

        symbolTable.delete(42);
        assert !symbolTable.contains(42);
        assert symbolTable.size() == 6;

        symbolTable.delete(3);
        symbolTable.delete(8);
        symbolTable.delete(888);
        symbolTable.delete(257);
        symbolTable.delete(16);
        symbolTable.delete(321);

        assert symbolTable.isEmpty();
    }

    private static void inspectBalancedBSTHeight(RedBlackBinarySearchTree<Integer, String> tree) {
        tree.put(1, "1");
        tree.put(2, "2");
        tree.put(3, "3");
        tree.put(4, "4");
        tree.put(5, "5");
        tree.put(6, "6");
        tree.put(7, "7");
        tree.put(8, "8");
        tree.put(9, "9");
        tree.put(10, "10");
        tree.put(11, "11");
        tree.put(12, "12");
        tree.put(13, "13");
        tree.put(14, "14");
        tree.put(15, "15");
        tree.put(16, "16");
    }
}
