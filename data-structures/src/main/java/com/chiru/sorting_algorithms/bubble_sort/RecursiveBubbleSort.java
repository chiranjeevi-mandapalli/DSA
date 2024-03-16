package com.chiru.sorting_algorithms.bubble_sort;

import java.util.Arrays;

/**
 * @author Chiranjeevi
 */
public class RecursiveBubbleSort {
    //no. of comparsions = n*(n-1)/2
    static void bubbleSort(int arr[], int n) {
        if (n == 1)
            return;

        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) {
            return;
        }
        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = {64, 50, 66, 40, 12};

        bubbleSort(arr, arr.length);

        System.out.println("Sorted array : ");
        System.out.println(Arrays.toString(arr));
    }
}
