package ru.rybinskov.gb.lesson3.MyQueue;

import ru.rybinskov.gb.lesson3.MyQueue.interfaces.Dequeue;

public class DequeueImpl<E> implements Dequeue<E> {

    protected E[] data;
    protected int size;

    private static final int DEFAULT_TAIL_FROM_LEFT = -1;
    private static final int DEFAULT_LEFT_HEAD = 0;
    private final int DEFAULT_RIGHT_HEAD;
    private final int DEFAULT_RIGHT_TAIL;

    private int tailFromLeft;
    private int leftHead;
    private int tailFromRight;
    private int rightHead;

    public DequeueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.leftHead = DEFAULT_LEFT_HEAD;
        this.tailFromLeft = DEFAULT_TAIL_FROM_LEFT;
        this.DEFAULT_RIGHT_HEAD = data.length -1;
        this.DEFAULT_RIGHT_TAIL = data.length;
        this.rightHead = DEFAULT_RIGHT_HEAD;
        this.tailFromRight = DEFAULT_RIGHT_TAIL;
    }

    @Override // O(1)
    public boolean insert(E value) {
        if (isFull()) {
            return false;
        }

        if (tailFromLeft == data.length - 1) {
            tailFromLeft = DEFAULT_TAIL_FROM_LEFT;
        }

        data[++tailFromLeft] = value;
        size++;
        return true;
    }

    @Override // O(1)
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        if (leftHead == data.length) {
            leftHead = DEFAULT_LEFT_HEAD;
        }

        E removedValue = data[leftHead++];
        size--;
        return removedValue;
    }

    @Override
    public E peekHead() {
        return data[leftHead];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return data.length == size;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        if (tailFromRight == 0) {
            tailFromRight = DEFAULT_RIGHT_TAIL;
        }

        data[--tailFromRight] = value;
        size++;
        return true;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        if (rightHead == -1) {
            rightHead = DEFAULT_RIGHT_HEAD;
        }

        E removedValue = data[rightHead--];
        size--;
        return removedValue;
    }

    @Override
    public E peekRightHead() {
        return data[rightHead];
    }
}
