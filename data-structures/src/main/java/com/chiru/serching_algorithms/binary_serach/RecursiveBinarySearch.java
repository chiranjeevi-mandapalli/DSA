package com.chiru.serching_algorithms.binary_serach;

/**
 * @author Chiranjeevi
 */
public class RecursiveBinarySearch {
    private static int search(int[] arr, int left, int right, int key) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key)
                return mid;

            if (arr[mid] > key) {
                search(arr, left, mid - 1, key);
            } else {
                search(arr, mid + 1, right, key);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 4;
        arr[1] = 5;
        arr[2] = 20;
        arr[3] = 2;
        arr[4] = 4;
        arr[5] = 1;
        int key = 202;
        int index = search(arr, 0, arr.length - 1, key);
        if (index == -1) {
            System.out.println(key + " not found");
        } else {
            System.out.println(key + " is at index: " + index);
        }
    }
}
