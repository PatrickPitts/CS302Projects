package org.nerdcore.project1.package1;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Project: Project 1
 * Completion Time: XX Hours
 *
 * Honor Code: "I pledge that I have neither given nor received help from anyone
 * other than the instructor or the TAs for all program components here."
 *
 * */
public class BinaryTree<T> implements Serializable {
    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(T[] data) {
        if (verifyArray(data)) {
            this.data = data[0];
            this.attachLeft(build(data, 1));
            this.attachRight(build(data, 2));
        }
    }

    private boolean verifyArray(T[] data) {
        if (data.length == 0 || data[0] == null) return false;
        for (int i = 1; i < data.length; i++) {
            if ((i % 2 == 0 && data[(i - 2) / 2] == null) || data[(i - 1) / 2] == null) return false;
        }
        return true;
    }

    private BinaryTree<T> build(T[] data, int i) {
        if (i >= data.length) return null;
        BinaryTree<T> root = new BinaryTree<>(data[i]);
        root.attachLeft(build(data, 2 * i + 1));
        root.attachRight(build(data, 2 * i + 2));
        return root;
    }

    public T getData() {
        return data;
    }

    public void attachLeft(BinaryTree<T> tree) {
        if (tree != null) {
            this.left = tree;
        }
    }

    public void attachRight(BinaryTree<T> tree) {
        if (tree != null) {
            this.right = tree;
        }
    }

    public BinaryTree<T> detachLeft() {
        BinaryTree<T> t = this.left;
        this.left = null;
        return t;
    }

    public BinaryTree<T> detachRight() {
        BinaryTree<T> t = this.right;
        this.right = null;
        return t;
    }

    public boolean isEmpty() {
        return this.data == null;
    }

    public void printLevels() {
        Queue<BinaryTree<T>> Q = new LinkedList<>();
        Q.add(this);
        while (Q.size() > 0) {
            int n = Q.size();
            while (n-- > 0) {
                BinaryTree<T> BT = Q.poll();
                System.out.print("" + BT.getData().toString() + ", ");
                if (BT.left != null) {
                    Q.add(BT.left);
                }
                if (BT.right != null) {
                    Q.add(BT.right);
                }
            }
            System.out.println();
//            BinaryTree<T> BT = Q.poll();
//            System.out.println(BT);
//            if(BT.left != null){
//                Q.add(BT.left);
//            }
//            if(BT.right != null){
//                Q.add(BT.right);
//            }
        }
    }

    // In Order traversal L-C-R
    private void inOrder(BinaryTree<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.getData());
            System.out.print(", ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        System.out.println("In-Order Traversal");
        inOrder(this);
        System.out.println();
    }

    // Pre Order Traversal C-L-R
    private void preOrder(BinaryTree<T> tree) {

        if (tree != null) {
            System.out.print(tree.getData());
            System.out.print(", ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        System.out.println("Pre-Order Traversal");
        preOrder(this);
        System.out.println();
    }

    // Post Order Traversal L-R-C
    private void postOrder(BinaryTree<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.getData());
            System.out.print(", ");
        }
    }

    public void postOrder() {
        System.out.println("Post-Order Traversal");
        postOrder(this);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

class IllegalBinaryTreeArrayException extends Exception {
    public IllegalBinaryTreeArrayException(int i) {
        super(String.format("Bad Binary Tree Array; missing parent node at index" +
                "%d", i));
    }
}