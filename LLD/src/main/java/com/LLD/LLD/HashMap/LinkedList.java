package com.LLD.LLD.HashMap;

public class LinkedList<K, V> {

    Node<K, V> head;

    public LinkedList() {
        this.head = null;
    }

    public V get(K key) {
        if (this.head == null) {
            System.out.println("key not present");
            return null;
        } else {
            Node<K, V> temp = head;
            while (temp != null) {
                if (temp.getKey().equals(key)) {
                    return temp.getValue();
                }
                temp = temp.getNextNode();
            }
            return null;
        }
    }

    public void insert(K key, V val) {
        if (this.head == null) {
            head = new Node<>(key, val);
            return;
        } else {
            Node<K,V> nNode = new Node<>(key, val);
            Node<K,V> temp = head;
            while (temp.getNextNode() != null) {
                if (temp.getKey().equals(key)) {
                    temp.setValue(val);
                    return;
                }
                temp = temp.getNextNode();
            }
            if (temp.getKey().equals(key)) {
                temp.setValue(val);
                return;
            }
            temp.setNextNode(nNode);
        }
    }

    public void remove(K key) {
        if (this.head == null) {
            System.out.println("key not present to remove");
            return;
        }

        if (head.getKey().equals(key)) {
            head = head.getNextNode();
            return;
        }

        Node<K, V> temp = head;

        while (temp.getNextNode() != null) {
            if (temp.getNextNode().getKey().equals(key)) {
                temp.setNextNode(temp.getNextNode().getNextNode());
                return;
            }
            temp = temp.getNextNode();
        }
        System.out.println("Key not present to remove");
    }

}
