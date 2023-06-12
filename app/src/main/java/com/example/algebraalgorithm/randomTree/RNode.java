package com.example.algebraalgorithm.randomTree;


public class RNode {
    public RNode(int key) {
        this.key = key;
        this.size = 1;
        this.left = null;
        this.right = null;
    }

    int key;
    int size;
    RNode left;
    RNode right;

    @Override
    public String toString() {
        return "RNode{" +
                "key=" + key +
                ", size=" + size +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

