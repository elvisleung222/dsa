package com.elvis.dsa.structure.collection;

public interface List<T> {
    T get(int index);

    void add(T element);

    T remove(T element);

    int size();
}
