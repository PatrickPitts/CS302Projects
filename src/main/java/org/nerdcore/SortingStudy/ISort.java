package org.nerdcore.SortingStudy;

public abstract class ISort {

    public static void sort(int[] x){};
    protected static void swap(int[] x, int a, int b){
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
