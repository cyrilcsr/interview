package com.algorithms.leetcode;

/*
Leeetcode 2100
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class GoodDaysToRobBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        ArrayList<Integer> results = new ArrayList<>();
        int[] monoIn = new int[security.length];
        int[] monoDe = new int[security.length];

        int prev = -1;
        int count = 0;
        for(int i=0;i<security.length;i++){
            if(prev>=security[i]){
                count++;
            }else{
                count = 0;
            }
            monoIn[i] = count;
            prev = security[i];

        }
        prev = -1;
        count = 0;
        for(int i=security.length-1;i>=0;i--){
            if(prev>=security[i]){
                count++;
            }else{
                count = 0;
            }
            monoDe[i] = count;
            prev = security[i];

        }

        for(int i=0;i<security.length;i++){
            if(monoIn[i]>=time&&monoDe[i]>=time){
                results.add(i);
            }
        }
        return results;
    }
}
