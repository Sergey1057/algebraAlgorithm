package com.example.algebraalgorithm.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayListFasade <T> implements IArray<T> {

    public List<T> arrayList;

    public ArrayListFasade() {
        arrayList = new ArrayList<T>();
    }

    @Override
    public void put(T item) {
        arrayList.add(item);
    }

    @Override
    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public void add(T item, int index) {
        arrayList.add(index, item);
    }

    @Override
    public T remove(int index) {
        return arrayList.remove(index);
    }
}
