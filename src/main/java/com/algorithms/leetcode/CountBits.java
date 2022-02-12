package com.algorithms.leetcode;

/*
JianZhi Offer 2-003
Leeetcode 0338
 */
public class CountBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = countOnes(i);
        }
        return result;
    }

    private int countOnes(int i) {
        int count = 0;
        while (i > 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }

    public int[] countBits2(int n) {
        int[] result = new int[n + 1];

        for (int i = 1; i < n+1; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
