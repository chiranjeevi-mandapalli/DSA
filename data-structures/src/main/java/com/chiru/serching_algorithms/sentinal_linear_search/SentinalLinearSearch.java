package com.chiru.serching_algorithms.sentinal_linear_search;

/**
 * @author Chiranjeevi
 */
public class SentinalLinearSearch {
    private static int search(int[] arr, int key) {
        int last = arr[arr.length - 1];
        arr[arr.length - 1] = key;
        int i = 0;
        while (arr[i] != key) {
            i++;
        }
        arr[arr.length - 1] = last;
        if(i< arr.length-1 || arr[arr.length-1] == key){
            return i;
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
        int key = 20;
        int index = search(arr, key);
        if (index == -1) {
            System.out.println(key + " not found");
        } else {
            System.out.println(key + " is at index: " + index);
        }
    }
}
