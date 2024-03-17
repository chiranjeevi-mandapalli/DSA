package com.chiru.problems;

/**
 * @author Chiranjeevi
 */
public class FindMedian {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                k++;
                j++;
            } else {
                result[k] = nums1[i];
                k++;
                i++;
            }
        }
        while (i < nums1.length) {
            result[k] = nums1[i];
            k++;
            i++;
        }
        while (j < nums2.length) {
            result[k] = nums2[j];
            k++;
            j++;
        }
        int median = result.length / 2;
        return result.length % 2 != 0 ? (double) (result[median]) : (double) (result[(median) - 1] + result[(median)]) / 2;

    }
}
