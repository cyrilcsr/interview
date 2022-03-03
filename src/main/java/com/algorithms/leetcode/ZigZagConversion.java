package com.algorithms.leetcode;

import java.util.ArrayList;

/*
Leeetcode 0006
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        char[] inputString = s.toCharArray();
        int len = s.length();
        if(numRows==1||len==1){
            return s;
        }
        int period = 2*numRows-2;
        for(int i=0;i<numRows;i++){
            for(int j=0;j+i<len;j+=period){
                sb.append(inputString[j+i]);
                if(0<i&&i<numRows-1&&j+period-i<len){
                    sb.append(inputString[j+period-i]);
                }
            }
        }

        return sb.toString();
    }
}
