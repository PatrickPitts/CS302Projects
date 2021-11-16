package org.nerdcore.SortingStudy;

/**
 * Utility Class that implements Bubble Sort.
 * Bubble Sort is an iterative sorting algorithm that iterates
 */
public class BubbleSort extends ISort{
    public static void sort(int[] x){
        for(int n = 0; n < x.length; n++){
            for(int i = 0; i < x.length-1; i++){
                if(x[i]>x[i+1])swap(x, i, i+1);
            }
        }
    }
}
