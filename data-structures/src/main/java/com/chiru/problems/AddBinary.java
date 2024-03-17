package com.chiru.problems;

/**
 * @author Chiranjeevi
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        String carry = "0";
        String result = "";
        while (i >= 0 && j >= 0) {
            int sum = Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(j)))
                    + Integer.parseInt(String.valueOf(carry.charAt(0)));
            if (sum == 0) {
                carry = "0";
                result = "0" + result;
                i--;
                j--;
                continue;
            }
            if (sum == 1) {
                carry = "0";
                result = "1" + result;
                i--;
                j--;
                continue;
            }
            if (sum == 2) {
                carry = "1";
                result = "0" + result;
                i--;
                j--;
                continue;
            }
            if (sum == 3) {
                carry = "1";
                result = "1" + result;
                i--;
                j--;
            }
        }
        while (i >= 0) {
            int sum = Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(carry.charAt(0)));
            if (sum == 0) {
                carry = "0";
                result = "0" + result;
                i--;
                continue;
            }
            if (sum == 1) {
                carry = "0";
                result = "1" + result;
                i--;
                continue;
            }
            if (sum == 2) {
                carry = "1";
                result = "0" + result;
                i--;
                continue;
            }
            if (sum == 3) {
                carry = "1";
                result = "1" + result;
                i--;
            }
        }

        while (j >= 0) {
            int sum = Integer.parseInt(String.valueOf(b.charAt(j))) + Integer.parseInt(String.valueOf(carry.charAt(0)));
            if (sum == 0) {
                carry = "0";
                result = "0" + result;
                j--;
                continue;
            }
            if (sum == 1) {
                carry = "0";
                result = "1" + result;
                j--;
                continue;
            }
            if (sum == 2) {
                carry = "1";
                result = "0" + result;
                j--;
                continue;
            }
            if (sum == 3) {
                carry = "1";
                result = "1" + result;
                j--;
            }
        }
        if (carry.charAt(0) == '1') {
            result = carry + result;
        }

        return result;
    }
}
