package com.example.algebraalgorithm.tree;


public class BSTNode {
    int key;
    BSTNode left;
    BSTNode right;

    public void setKey(int key) {
        this.key = key;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}