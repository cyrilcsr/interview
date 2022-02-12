package com.algorithms.leetcode;

/*
JianZhi Offer 2-005
Leeetcode 0318
 */
public class MaxProduct {
    public int maxProduct(String[] words) {
        int[] letterCounts = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                letterCounts[i] |= 1 <<  words[i].charAt(j) - 'a';
            }
        }

        int maxLength = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if((letterCounts[i]&letterCounts[j])==0){
                    maxLength = Math.max(words[i].length()*words[j].length(), maxLength);
                }
            }
        }
        return maxLength;
    }
}
