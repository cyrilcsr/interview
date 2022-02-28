package com.algorithms.jianZhi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
JianZhi Offer 2-038
Leeetcode 0739
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                int index = stack.pop();
                results[index]=i-index;
            }
            stack.push(i);
        }

        return results;
    }
}
