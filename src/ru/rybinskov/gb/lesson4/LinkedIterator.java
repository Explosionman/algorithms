package ru.rybinskov.gb.lesson4;

import java.util.Iterator;

public class LinkedIterator<E> implements Iterator<E> {
    SimpleLinkedListImpl<E> list;
    LinkedList.Node<E> cursor;

    public LinkedIterator(SimpleLinkedListImpl<E> list) {
        this.list = list;
        this.cursor = list.firstElement;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public E next() {
        E item = cursor.item;
        cursor = cursor.next;
        return item;
    }
}
