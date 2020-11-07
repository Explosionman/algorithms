package ru.rybinskov.gb.lesson3.MyQueue.interfaces;

public interface Queue<E> {

    boolean insert(E value);

    E remove();

    E peekHead();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    boolean isFull();
}
