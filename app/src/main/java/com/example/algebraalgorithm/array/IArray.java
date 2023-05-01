package com.example.algebraalgorithm.array;

public interface IArray<T> {

    void put(T item);
    T get(int index);
    int size();
    boolean isEmpty();

    void add(T item, int index);
    T remove(int index);

}
