package ru.rybinskov.gb.lesson3;

import ru.rybinskov.gb.lesson3.MyQueue.DequeueImpl;
import ru.rybinskov.gb.lesson3.MyQueue.interfaces.Dequeue;
import ru.rybinskov.gb.lesson3.MyQueue.interfaces.Queue;
import ru.rybinskov.gb.lesson3.MyQueue.QueueImpl;
import ru.rybinskov.gb.lesson3.MyStack.Stack;
import ru.rybinskov.gb.lesson3.MyStack.StackImpl;

public class Test {
    public static void main(String[] args) {
//        testStack();
        testQueue();
    }

    private static void init() {

    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);

        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6));

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

    private static void testQueue() {
//        Queue<Integer> queue = new QueueImpl<>(5);
//        Queue<Integer> queue = new PriorityQueueImpl<>(5);
        Dequeue<Integer> queue = new DequeueImpl<>(6);
        System.out.println("Add value 3: " + queue.insert(3));
        System.out.println("Add value 5: " + queue.insert(5));
        System.out.println("Add value 1: " + queue.insert(1));
        System.out.println("Add value 2: " + queue.insertRight(2));
        System.out.println("Add value 6: " + queue.insertRight(6));
        System.out.println("Add value 4: " + queue.insertRight(4));
        System.out.println("Add value 9: " + queue.insertRight(9));
        System.out.println("____________________________________________");
        System.out.println("Queue peek left: " + queue.peekHead());
        System.out.println("Queue peek right: " + queue.peekRightHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());
        System.out.println("____________________________________________");

        while (!queue.isEmpty()) {
            System.out.println(queue.removeRight());
        }
    }
}
