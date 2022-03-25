package com.algorithms.leetcode.Integer;

/*
Leeetcode 0172
*/
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        while(n!=0){
            result+=n/5;
            n/=5;
        }
        return result;
    }
}
