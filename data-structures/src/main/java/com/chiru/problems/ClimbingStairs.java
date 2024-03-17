package com.chiru.problems;

/**
 * @author Chiranjeevi
 */
public class ClimbingStairs {
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1, second = 1;

        int next = 0;
        for (int i = 0; i < n - 2; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        return next;
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        int total = 3;
        int i = 4;
        while (i <= n) {
            total = total + fibonacci(i - 1);
            i++;
        }
        return total;
    }
}
