package com.LLD.LLD.HashMap;

public class HashMap<K,V> {

    LinkedList<K,V> arr[] = new LinkedList[10];

    public HashMap(){
        for(int i=0;i<arr.length;i++){
            arr[i] = new LinkedList<>();
        }
    }

    public int generateHash(K key) {
        return Math.abs(key.hashCode()) % arr.length;
    }

    public V get(K key) {
        int ind = generateHash(key);
        return arr[ind].get(key);
    }

    public void put(K key, V value) {
        int ind = generateHash(key);
        arr[ind].insert(key, value);
    }

    public void delete(K key) {
        int ind = generateHash(key);
        arr[ind].remove(key);
    }

}
