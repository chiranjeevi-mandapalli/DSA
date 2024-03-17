package com.chiru.problems;

/**
 * @author Chiranjeevi
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }
    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }
}
