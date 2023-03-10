package com.example.algebraalgorithm;

public class Shell {

    private SimpleSorting simpleSorting;
    private int N;
    private int[] A;

    public Shell(Integer Num) {
        simpleSorting = new SimpleSorting();
        simpleSorting.setRandom(Num);
        N = simpleSorting.getN();
        A = simpleSorting.getA();
    }

    public void shell(Integer Num) {
        for (int gap = N; gap > 0; gap /= 2) {
            for (int i = gap; i < N; i++) {
                for (int j = i; j >= gap && A[j - gap] > A[j]; j -= gap) {
                    simpleSorting.swap(j - gap, j);
                }
            }
        }
    }
}
