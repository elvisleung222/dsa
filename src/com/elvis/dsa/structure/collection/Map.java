package com.elvis.dsa.structure.collection;

/**
 * @author elvis
 * @date 2020/6/2
 * @company
 */
public interface Map<K, V> {
    V put(K key, V value);

    V get(K key);

    V remove(K key);
}
