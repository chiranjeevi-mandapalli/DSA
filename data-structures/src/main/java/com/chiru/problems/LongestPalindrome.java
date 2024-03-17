package com.chiru.problems;

/**
 * @author Chiranjeevi
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int firstIndex = -1;
        int lastIndex = -1;
        boolean entered = false;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                if (!entered) {
                    firstIndex = i;
                    lastIndex = j;
                    entered = true;
                }
                i++;
                j--;
            } else {
                i = i + 1;
                if (s.charAt(i) != s.charAt(j)) {
                    j = j - 1;
                }
                firstIndex = -1;
                lastIndex = -1;
                entered = false;
            }
        }
        boolean palindrome = firstIndex != -1 && lastIndex != -1;
        return palindrome ? s.substring(firstIndex, lastIndex + 1) : null;
    }

    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
