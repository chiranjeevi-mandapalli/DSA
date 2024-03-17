package com.chiru.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chiranjeevi
 */
public class LengthOfLongestSubstring {
    private static int findMaxLength(List<String> existingValues, int max) {
        for (int i = 0; i < existingValues.size(); i++) {
            int length = existingValues.get(i).length();
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s != null && !s.isEmpty()) {
            List list = new ArrayList<String>();
            StringBuilder subString = new StringBuilder();
            int max = 0;
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                if (list.contains(String.valueOf(s.charAt(i)))) {
                    list.add(subString.toString());
                    max = findMaxLength(list, max);
                    list.clear();
                    i = index;
                    index++;
                    subString = new StringBuilder();
                } else {
                    subString.append(s.charAt(i));
                    list.add(String.valueOf(s.charAt(i)));
                }
            }
            if (!subString.toString().isEmpty()) {
                list.add(subString.toString());
                max = findMaxLength(list, max);
                list.clear();
            }
            return max;
        } else {
            return 0;
        }

    }
}
