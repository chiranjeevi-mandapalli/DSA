package com.chiru.problems;

/**
 * @author Chiranjeevi
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int maxLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < maxLength && j < strs[i].length()) {
                if (strs[i].charAt(j) == strs[0].charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            maxLength = j;
        }
        return maxLength == 0 ? "" : strs[0].substring(0, maxLength);
    }
}
