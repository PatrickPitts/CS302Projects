package org.nerdcore.project1.package1;

import java.util.*;

/*
 * Project: Project 1
 * Completion Time: XX Hours
 *
 * Honor Code: "I pledge that I have neither given nor received help from anyone
 * other than the instructor or the TAs for all program components here."
 *
 * */
public class App {


    public static BinaryTree<String> build(String[] data, int i){
        if(i >= data.length)return null;
        BinaryTree<String> root = new BinaryTree<>(data[i]);
        root.attachLeft(build(data, 2*i + 1));
        root.attachRight(build(data, 2*i + 2));
        return root;
    }

    public static void main(String[] args) {
//        int N = 10;
//        Integer[] base = new Integer[N];
//        for(int i = 0; i < N; i++){
//            base[i] = i+1;
//        }
//        Integer[] base = new Integer[]{40,20,60,10,30,50,70};
//        BinaryTree<Integer> root = new BinaryTree<>(base);
//        root.printLevels();

        

    }
}

class BinarySearchTree<T> implements Set<T>{

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }
}
