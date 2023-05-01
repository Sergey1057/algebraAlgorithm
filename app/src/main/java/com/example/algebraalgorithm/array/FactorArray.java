package com.example.algebraalgorithm.array;

public class FactorArray<T> implements IArray<T> {


    public T[] array;
    int factor = 2;
    int size;

    public FactorArray() {
        size = 0;
        array = (T[]) new Object[1];
    }

    @Override
    public void put(T item) {
        if (size() == array.length ){
            resize();
        }

        array[size()] = item;
        size++;
    }

    void resize(){
        T[] newArray = (T[])new Object[size() * factor + 1];
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
        return size;
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

