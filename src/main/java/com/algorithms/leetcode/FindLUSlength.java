package com.algorithms.leetcode;

/*
Leeetcode 0521
 */
public class FindLUSlength {
    public int findLUSlength(String a, String b) {
        return a.equals(b)?-1:Math.max(a.length(),b.length());
    }
}
