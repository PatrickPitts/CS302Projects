package org.nerdcore.SortingStudy;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] arr = {16,46,32,40,46,55,50,43,44,33,12,17,95,80,75,81,80, 61,59, 87};

        int[] cp = Arrays.copyOf(arr, arr.length);
        BubbleSort.sort(cp);
        System.out.println(Arrays.toString(cp));
        System.out.println(Arrays.toString(arr));

    }
}
