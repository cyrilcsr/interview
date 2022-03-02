package com.algorithms.leetcode;

import java.util.ArrayList;

/*
Leeetcode 0564
 */
public class NearestPalindromic {
    public String nearestPalindromic(String n) {
        long inNum = Long.parseLong(n);

        if(n.length()==1){
            return String.valueOf(inNum-1);
        }

        ArrayList<Long> candidates = new ArrayList<>();

        candidates.add((long)Math.pow(10,n.length()-1)-1);
        candidates.add((long)Math.pow(10,n.length())+1);

        long selfPrefix = Long.parseLong(n.substring(0,(n.length()+1)/2));

        for(long i=selfPrefix-1;i<=selfPrefix+1;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            StringBuilder suffix = new StringBuilder(String.valueOf(i)).reverse();
            sb.append(suffix.substring(n.length()&1));
            candidates.add(Long.parseLong(sb.toString()));
        }

        long result = 0;
        Long minDiff = Long.MAX_VALUE;

        for(long l:candidates){
            long diff = Math.abs(l-inNum);
            if(diff!=0){
                if(minDiff>diff){
                    minDiff = diff;
                    result = l;
                }else if(minDiff==diff && result>l){
                    result = l;
                }
            }
            minDiff = diff==0 ? minDiff : Math.min(diff,minDiff);
        }

        return String.valueOf(result);
    }
}
