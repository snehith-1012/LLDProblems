package com.LLD.LLD.HashMap;

public class Node<K,V> {

    private K key;

    private V value;

    private Node nextNode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.nextNode = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
