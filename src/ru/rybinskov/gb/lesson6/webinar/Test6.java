package ru.rybinskov.gb.lesson6.webinar;

import java.util.Random;

public class Test6 {

    public static void main(String[] args) {
        int min1 = -26;
        int min2 = -101;

        int max1 = 26;
        int max2 = 101;

        int maxLevel1 = 4;
        int maxLevel2 = 6;

        int iterations = 63;

        //    testTree();
        System.out.println(testTrees(20, maxLevel1, iterations, min1, max1) + "%");
        System.out.println(testTrees(20, maxLevel2, iterations, min2, max2) + "%");

        //      testRemoveElement();
    }

    private static double testTrees(int quantity, int maxLevel, int iterations, int min, int max) {
        int counter = 0;
        Random random = new Random();
        Tree<Integer> tree;
        for (int i = 0; i < quantity; i++) {
            tree = new TreeImpl<>(maxLevel);
            for (int j = 0; j < iterations; j++) {
                tree.add(random.ints(min, (max)).findFirst().getAsInt());
            }
            if (tree.isBalanced()) {
                counter++;
            }
        }
        System.out.printf("With maxLevel = %d , minValue = %d, maxValue = %d:\n", maxLevel, min, max);
        return (100 / quantity) * counter;
    }

    private static void testRemoveElement() {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(25);
        tree.add(66);
        tree.add(15);
        tree.add(5);
        tree.add(20);
        tree.add(45);
        tree.add(30);
        tree.add(55);
        tree.add(32);

        tree.remove(25);
        tree.display();
    }

    private static void testTree() {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(67);
        tree.add(81);

        System.out.println("Find 70: " + tree.contains(70));
        System.out.println("Find 700: " + tree.contains(700));

        tree.display();
//        tree.traverse(Tree.TraverseMode.IN_ORDER, System.out::println);
//        tree.traverse(Tree.TraverseMode.PRE_ORDER, System.out::println);
//        tree.traverse(Tree.TraverseMode.POST_ORDER, System.out::println);
    }
}
