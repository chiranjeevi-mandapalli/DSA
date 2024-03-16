package com.chiru.sorting_algorithms.selection_sort;

/**
 * @author Chiranjeevi
 */
public class SelectionSort {
    //this selection sort may not work for large datasets in order to make it stable
    //instead of swapping push the elements forward by placing the element in coreect position
    private static int[] sort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[i]) {
//                    int temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }

    private static void swap(int[] arr, int j, int i) { //j is big, i is small
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 4;
        arr[1] = 5;
        arr[2] = 3;
        arr[3] = 2;
        arr[4] = 4;
        arr[5] = 1;
        printArray(sort(arr));
    }
}
