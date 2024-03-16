package com.chiru.serching_algorithms.exponential_search;

/**
 * @author Chiranjeevi
 */
public class ExponentialSearch {
    private static int search(int[] arr, int key) {
        if (arr.length == 0) {
            return -1;
        }
        int i = 1;
        if (i < arr.length && arr[i] < key) {
            i = i * 2;
        }

        int left = i / 2;
        int right = Math.min(i, arr.length-1);
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        //array should be in sorted in order to apply binary search
        int[] arr = new int[6];
        arr[0] = 70;
        arr[1] = 72;
        arr[2] = 90;
        arr[3] = 102;
        arr[4] = 200;
        arr[5] = 250;
        int key = 250;
        int index = search(arr, key);
        if (index == -1) {
            System.out.println(key + " not found");
        } else {
            System.out.println(key + " is at index: " + index);
        }
    }
}
