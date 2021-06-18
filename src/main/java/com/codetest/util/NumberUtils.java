package com.codetest.util;

public class NumberUtils {

    public static boolean isDivisibleByN(int input, int n) {
        return input % n == 0;
    }

    public static boolean hasN(int input, int n) {
        return String.valueOf(input).contains(String.valueOf(n));
    }
}
