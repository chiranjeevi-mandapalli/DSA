package com.chiru.problems;

/**
 * @author Chiranjeevi
 */
public class RomanToInt {
    //    I can be placed before V (5) and X (10) to make 4 and 9.
//    X can be placed before L (50) and C (100) to make 40 and 90.
//    C can be placed before D (500) and M (1000) to make 400 and 900.
    public static int romanToInt(String s) {
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'V') {
                    value = value + 4;
                    i = i + 1;
                    continue;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'X') {
                    value = value + 9;
                    i = i + 1;
                    continue;
                } else {
                    value = value + 1;
                }
            }
            if (s.charAt(i) == 'V') {
                value = value + 5;
            }
            if (s.charAt(i) == 'X') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'L') {
                    value = value + 40;
                    i = i + 1;
                    continue;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'C') {
                    value = value + 90;
                    i = i + 1;
                    continue;
                } else {
                    value = value + 10;
                }
            }
            if (s.charAt(i) == 'L') {
                value = value + 50;
            }
            if (s.charAt(i) == 'C') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'D') {
                    value = value + 400;
                    i = i + 1;
                    continue;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'M') {
                    value = value + 900;
                    i = i + 1;
                    continue;
                } else {
                    value = value + 100;
                }
            }
            if (s.charAt(i) == 'D') {
                value = value + 500;
            }
            if (s.charAt(i) == 'M') {
                value = value + 1000;
            }

        }
        return value;
    }

}
