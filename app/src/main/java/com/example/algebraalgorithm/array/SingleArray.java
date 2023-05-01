package com.example.algebraalgorithm.array;

import java.util.ArrayList;

public class SingleArray<T> implements IArray<T>{

    public T[] array;

    public SingleArray() {
        array = (T[]) new Object[0];
    }

    public static void testPut(IArray<Integer> array, int total){
        long srart = System.currentTimeMillis();
        for (int j = 0; j < total; j++){
            array.put(j);
        }
        System.out.println(array + " testPut: " + total + " "
                + (System.currentTimeMillis() - srart));
    }

    @Override
    public void put(T item) {
        resize();
        array[size() - 1] = item;
    }

    void resize(){
        T[] newArray = (T[])new Object[size() + 1];
        for (int j = 0; j < size(); j++){
            newArray[j] = array[j];
        }
        array =  newArray;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(T item, int index) {
        T[] newArray = (T[])new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index, newArray, index+1, array.length - index);
        newArray[index] = item;
        array = newArray;
    }

    @Override
    public T remove(int index) {
        T[] newArray = (T[])new Object[size() - 1];
        for(int i=0, k=0;i<array.length;i++){
            if(i!=index){
                newArray[k]=array[i];
                k++;
            }
        }
        T result = array[index];
        array = newArray;
        return result;
    }

}
