package com.chiru.problems;

/**
 * @author Chiranjeevi
 */
public class ValidParanthesis {
    public static boolean isValid(String s) {
        char[] paranthesis = new char[s.length()];
        int j = -1;
        if (s.length() <= 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                j++;
                paranthesis[j] = s.charAt(i);
                continue;
            }
            if (s.charAt(i) == ')' && j != -1 && paranthesis[j] == '(') {
                j--;
                continue;
            }
            if (s.charAt(i) == '}' && j != -1 && paranthesis[j] == '{') {
                j--;
                continue;
            }
            if (s.charAt(i) == ']' && j != -1 && paranthesis[j] == '[') {
                j--;
            }
        }
        return j == -1;
    }
}
