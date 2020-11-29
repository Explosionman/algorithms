package ru.rybinskov.gb.lesson8;

import java.util.LinkedList;

public class LinkedHashTableImpl<K, V> implements HashTable<K, V> {
    static class Node<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final LinkedList<Node<K, V>>[] data;
    private int size;

    public LinkedHashTableImpl(int capacity) {
        this.data = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            data[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);
        data[index].addLast(new Node<>(key, value));
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if (index == -1) return null;
        LinkedList<Node<K, V>> linkedList = data[index];
        for (Node<K, V> kvNode : linkedList) {
            if (kvNode.getKey().equals(key)) {
                return kvNode.getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);
        if (index == -1) return null;
        LinkedList<Node<K, V>> linkedList = data[index];
        for (Node<K, V> kvNode : linkedList) {
            if (kvNode.getKey().equals(key)) {
                Node<K, V> tmp = kvNode;
                linkedList.remove(kvNode);
                size--;
                return tmp.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("----------");
    }
}
