package com.example.algebraalgorithm.tree;



public class BSTTree {
    private BSTNode rootNode;

    public BSTTree() {
        rootNode = null;
    }


    public void insertNode(int value) {
        BSTNode newNode = new BSTNode();
        newNode.setKey(value);
        if (rootNode == null) {
            rootNode = newNode;
        }
        else {
            BSTNode currentNode = rootNode;
            BSTNode parentNode;
            while (true)
            {
                parentNode = currentNode;
                if(value == currentNode.getKey()) {
                    return;
                }
                else  if (value < currentNode.getKey()) {
                    currentNode = currentNode.getLeft();
                    if (currentNode == null){
                        parentNode.setLeft(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }


    public boolean search(int value) {
        BSTNode currentNode = rootNode;

        while (currentNode.getKey() != value) {
            if (value < currentNode.getKey()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return false;
            }
        }
        return true;
    }


    public void remove(int value)
    {
        BSTNode currentNode = rootNode;
        BSTNode parentNode = rootNode;
        boolean isLeftChild = true;
        while (currentNode.getKey() != value) {
            parentNode = currentNode;
            if (value < currentNode.getKey()) {
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            }
            else {
                isLeftChild = false;
                currentNode = currentNode.getRight();
            }
            if (currentNode == null)
                return ;
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == rootNode)
                rootNode = null;
            else if (isLeftChild)
                parentNode.setLeft(null); // если нет - узел отсоединяется, от родителя
            else
                parentNode.setRight(null);
        }
        else if (currentNode.getRight() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getLeft();
            else if (isLeftChild)
                parentNode.setLeft(currentNode.getLeft());
            else
                parentNode.setRight(currentNode.getLeft());
        }
        else if (currentNode.getLeft() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getRight();
            else if (isLeftChild)
                parentNode.setLeft(currentNode.getRight());
            else
                parentNode.setRight(currentNode.getRight());
        }
        else {
            BSTNode heir = receiveHeir(currentNode);
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeftChild)
                parentNode.setLeft(heir);
            else
                parentNode.setRight(heir);
        }
    }

    private BSTNode receiveHeir(BSTNode node) {
        BSTNode parentNode = node;
        BSTNode heirNode = node;
        BSTNode currentNode = node.getRight();
        while (currentNode != null)
        {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeft();
        }
        if (heirNode != node.getRight())
        {
            parentNode.setLeft(heirNode.getRight());
            heirNode.setRight(node.getRight());
        }
        return heirNode;
    }
}
