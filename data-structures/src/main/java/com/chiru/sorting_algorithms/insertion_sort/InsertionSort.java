package com.chiru.sorting_algorithms.insertion_sort;

/**
 * @author Chiranjeevi
 */
public class InsertionSort {
    private static int[] sort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            if(arr[j] > arr[i]){
                swap(arr,j,i);
            }
            printArray(arr);
            while (j>0 && arr[j-1]>arr[j]){
                swap(arr,j-1,j);
                j--;
            }
            printArray(arr);
        }
        return arr;
    }
    private static void swap(int [] arr,int j, int i){ //j is big, i is small
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] =temp;
    }
    private static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j+" ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 12;
        arr[1] = 0;
        arr[2] = 8;
        arr[3] = 5;
        arr[4] = 8;
        printArray(sort(arr));
    }
}
