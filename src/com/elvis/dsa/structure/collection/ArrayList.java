package com.elvis.dsa.structure.collection;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_SIZE = 5;
    private T[] arr = (T[]) new Object[DEFAULT_SIZE];
    private int capacity = DEFAULT_SIZE;
    private int size = 0;


    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        return arr[index];
    }

    @Override
    public void add(T element) {
        if (size >= capacity) {
            capacity = newCapacity(capacity);
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[size] = element;
        size++;
    }

    @Override
    public T remove(T element) {
        int i = 0;

        // Find the target element
        for (; i < size; i++) {
            if (element.equals(arr[i]))
                break;
        }

        // Not found
        if (i >= size)
            return null;

        T removedElement = arr[i];

        // Move the following elements 1 position forward
        for (; i < size - 1; i++)
            arr[i] = arr[i + 1];
        size--;
        return removedElement;
    }

    @Override
    public int size() {
        return size;
    }

    private int newCapacity(int oldCapacity) {
        return ((oldCapacity * 3) / 2) + 1;
    }
}
