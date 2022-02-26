package com.algorithms.jianZhi;

import java.util.HashMap;
import java.util.Map;

/*
JianZhi Offer 2-034
Leeetcode 0953
 */
public class isAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) {
            return true;
        }
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }


        search:for (int first = 0, second = 1; second < words.length; first++, second++) {
            char[] s1 = words[first].toCharArray();
            char[] s2 = words[second].toCharArray();
            int shorterLen = Math.min(s1.length, s2.length);
            for (int i = 0; i < shorterLen; i++) {
                if (s1[i] == s2[i]) {
                    continue;
                } else if (index[s1[i] - 'a'] > index[s2[i] - 'a']) {
                    return false;
                } else {
                    continue search;
                }
            }
            if(s1.length > s2.length){
                return false;
            }
        }
        return true;
    }
}
