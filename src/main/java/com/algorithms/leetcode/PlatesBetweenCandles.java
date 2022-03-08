package com.algorithms.leetcode;

/*
Leeetcode 2055
 */
public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] preSum = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        char[] sArray = s.toCharArray();

        int[] results = new int[queries.length];

        int sum = 0;
        for(int i=0;i<len;i++){
            if(sArray[i]=='*'){
                sum++;
            }
            preSum[i] = sum;
        }

        for(int i=0,l=-1,r=-1;i<len;i++){
            if(sArray[i]=='|'){
                l=i;
            }
            if(sArray[len-1-i]=='|'){
                r=len-1-i;
            }
            left[i]=l;
            right[len-1-i] = r;
        }

        for(int i=0;i<queries.length;i++){
            int x = right[queries[i][0]];
            int y = left[queries[i][1]];
            results[i] = x==-1|y==-1||x>=y?0:preSum[y]-preSum[x];
        }

        return results;
    }
}
