package com.elvis.dsa.structure.collection;

/**
 * @author elvis
 * @date 2020/6/2
 * @company
 */
public class HashMap<K, V> implements Map<K, V> {
    double DEFAULT_LOAD_FACTOR = 0.75;
    int DEFAULT_CAPACITY = 5;
    int currentOccupancy = 0;
    int size = DEFAULT_CAPACITY;
    Node[] arr = new Node[DEFAULT_CAPACITY];

    class Node<K, V> {
        K key;
        V value;
        Node next = null;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public V put(K key, V value) {
        int index = hash(key);
        if (arr[index] == null) {
            arr[index] = new Node(key, value);
            currentOccupancy++;
        } else {
            Node ptr = arr[index];
            V old;
            while (ptr.next != null) {
                if (ptr.key == key) {
                    old = (V) ptr.value;
                    ptr.value = value;
                    return old;
                }
                ptr = ptr.next;
            }
            ptr.next = new Node(key, value);
        }
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    /**
     * Calculate the index of a hash key
     *
     * @param key
     * @return
     */
    private int hash(K key) {
        int hash = key.hashCode();
        return Math.floorMod(hash, size);
    }

    private double currentLoad() {
        return currentOccupancy / size;
    }
}
