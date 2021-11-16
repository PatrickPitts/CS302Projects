package org.nerdcore.SortingStudy;

/**
 * Utility class that implements Insertion Sort
 *
 * Insertion Sort is an iterative algorithm that iterates through an array to be sorted.
 * For each element in the array, the algorithm repeatedly swaps that element with the element at the
 * index directly below it, until that value is greater than the element before it.
 *
 * worstTime(n) = O(n^2)
 * averageTime(n) = 0(n^2)
 */
public class InsertionSort extends ISort{
    public static void sort(int[] x){
        for(int i = 1; i < x.length; i++){
            for(int p = i; p >0 && x[p]<x[p-1]; p--){
                swap(x, p, p-1);
            }
        }
    }
}
