package com.chiru.problems;

/**
 * @author Chiranjeevi
 */
public class SquareRoot {
    public static int mySqrt(int number) {
        double epsilon = 1e-6;
        double estimatedValue = number / 2.0;

        while (Math.abs(estimatedValue * estimatedValue - number) > epsilon) {
            estimatedValue = 0.5 * (estimatedValue + number / estimatedValue);
        }

        return (int) estimatedValue;

    }
}
