package ru.rybinskov.gb.lesson3.MyQueue.interfaces;

public interface Dequeue<E> extends Queue<E> {

    boolean insertRight(E value);

    E removeRight();

    E peekRightHead();
}
