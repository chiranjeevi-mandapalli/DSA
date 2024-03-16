package com.chiru.sorting_algorithms.selection_sort;

/**
 * @author Chiranjeevi
 */
public class StableSelectionSort {
    private static int[] sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    while (j > i) {
                        arr[j] = arr[j - 1];
                        j--;
                    }
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j+" ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 64;
        arr[1] = 25;
        arr[2] = 32;
        arr[3] = 28;
        arr[4] = 4;
        arr[5] = 11;
        printArray(sort(arr));

    }
}
