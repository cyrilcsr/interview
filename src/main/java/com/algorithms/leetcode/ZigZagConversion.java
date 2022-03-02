package com.algorithms.leetcode;

import java.util.ArrayList;

/*
Leeetcode 0006
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        ArrayList<StringBuilder> results = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            results.add(new StringBuilder());
        }
        int index = 0;
        for(char c:s.toCharArray()){
            results.get(index).append(c);
            if()
        }
    }
}
