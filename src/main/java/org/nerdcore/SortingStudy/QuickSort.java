package org.nerdcore.SortingStudy;

/**
 * Utility class implementing Quick Sort
 *
 * Quick Sort is a divide-and-conquer algorithm that sorts an array
 * Averaget Time O(n log(n))
 *
 */
public class QuickSort extends ISort{
    public static void sort(int[] a) {
        sort1(a, 0, a.length);
    }

    /**
     * @param x   array to be sorted
     * @param off starting index of subarray being sorted
     * @param len length of subarray being sorted
     */
    private static void sort1(int[] x, int off, int len) {
        //chose pivot
        //for element index < pivot, flag an element that is greater than pivot
        //for element index > pivot, flag an element that is less than pivot
        //swap flagged elements
        //repeat until flags are equal, or at pivot

        //gets three potential medians from the subarray: first, last, and midpoint of subarray
        int m = off + (len >> 1),
                l = off,
                n = off + len - 1;
        //finds and saves the median of the three potentials chosen above
        m = med3(x, l, m, n);
        int v = x[m];
        int L = off, R = off + len - 1;
        while (true) {
            //Looking for value located before pivot index that is greater than pivot
            while (L <= R && x[L] < v) L++;
            //Looking for value located after pivot index that is less than pivot
            while (L <= R && x[R] > v) R--;
            //This 'if' triggers if there are no more simultaneous elements too big below and too small above
            if (L > R) break;
            //actually swaps the terms at L and R
            swap(x, L++, R--);
        }
        if (R - off + 1 > 1) {
            sort1(x, off, R - off + 1);
        }
        if (off + len - L > 1){
            sort1(x, L, off + len - L);
        }
    }

    private static int med3(int[] x, int a, int b, int c) {
        return (x[a] < x[b] ?
                (x[b] < x[c] ? b : x[a] < x[c] ? c : a) :
                (x[b] > x[c] ? b : x[a] > x[c] ? c : a));
    }

//    private static void swap(int[] x, int a, int b) {
//        int t = x[a];
//        x[a] = x[b];
//        x[b] = t;
//    }
}
