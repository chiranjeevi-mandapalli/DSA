package com.chiru.sorting_algorithms.bubble_sort;

/**
 * @author Chiranjeevi
 */
public class BubbleSort {
    //no. of comparsions = n*(n-1)/2
    private static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        return arr;
    }


    private static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 30;
        arr[1] = 40;
        arr[2] = 50;
        arr[3] = 60;
        arr[4] = 55;
        printArray(sort(arr));

    }
}
