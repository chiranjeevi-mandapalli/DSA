package com.chiru.serching_algorithms.binary_serach;

/**
 * @author Chiranjeevi
 */
public class BinarySearch {
    private static int search(int [] arr, int key){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;
//            int mid = left+right/2;
            if(arr[mid] == key)
                return mid;

            if(arr[mid] > key){
                right = mid-1;
            }else {
                left = mid+1;
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
        int key =250;
        int index = search(arr, key);
        if(index == -1){
            System.out.println(key+ " not found");
        }else {
            System.out.println(key+ " is at index: "+index);
        }
    }
}
