package com.algorithms.leetcode;

import java.util.ArrayDeque;

/*
Leeetcode 2104
 */
public class SubArrayRanges {
    public long subArrayRanges(int[] nums) {
        ArrayDeque<Integer> monoIn = new ArrayDeque<>();
        ArrayDeque<Integer> monoDe = new ArrayDeque<>();
        long maxSum = 0,minSum = 0;
        int len = nums.length;

        for(int i=0;i<len;i++){
            while(!monoIn.isEmpty()&&nums[monoIn.peek()]>nums[i]){
                int peek = monoIn.pop();
                if(monoIn.isEmpty()){
                    minSum += (long) (i - peek) *(peek+1)*nums[peek];
                }else{
                    minSum += (long) (i - peek) *(peek-monoIn.peek())*nums[peek];
                }
            }
            monoIn.push(i);

            while(!monoDe.isEmpty()&&nums[monoDe.peek()]<nums[i]){
                int peek = monoDe.pop();
                if(monoDe.isEmpty()){
                    maxSum += (long) (i - peek) *(peek+1)*nums[peek];
                }else{
                    maxSum += (long) (i - peek) *(peek-monoDe.peek())*nums[peek];
                }
            }
            monoDe.push(i);
        }

        while(!monoIn.isEmpty()){
            int peek = monoIn.pop();
            if(!monoIn.isEmpty()) {
                minSum += (long) (len - peek) *(peek-monoIn.peek())*nums[peek];
            }else{
                minSum += (long) (len - peek) *(peek+1)*nums[peek];
            }
        }

        while(!monoDe.isEmpty()){
            int peek = monoDe.pop();
            if(!monoDe.isEmpty()) {
                maxSum += (long) (len - peek) *(peek-monoDe.peek())*nums[peek];
            }else{
                maxSum += (long) (len - peek) *(peek+1)*nums[peek];
            }
        }

        return maxSum-minSum;
    }
}
