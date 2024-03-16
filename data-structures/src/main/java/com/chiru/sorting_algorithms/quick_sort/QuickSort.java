package com.chiru.sorting_algorithms.quick_sort;

/**
 * @author Chiranjeevi
 */
public class QuickSort {

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int start = low;
        int end = high;
        while (start < end) {
            while (arr[start] <= pivot) {
                start++;
                if(start==high){
                    break;
                }

            }
            while (arr[end] > pivot) {
                end--;
                if(end==low){
                    break;
                }
            }
            if (start < end) {
                swap(arr, start, end);
            }
        }
        swap(arr, low, end);
        return end;
    }


    private static int[] sort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            sort(arr, low, partition - 1);
            sort(arr, partition + 1, high);
        }
        return arr;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] arr = new int[9];
        arr[0] = 7;
        arr[1] = 6;
        arr[2] = 10;
        arr[3] = 5;
        arr[4] = 9;
        arr[5] = 2;
        arr[6] = 1;
        arr[7] = 15;
        arr[8] = 7;
        int[] sorted = sort(arr, 0, arr.length - 1);
        printArray(sorted);
    }
}
