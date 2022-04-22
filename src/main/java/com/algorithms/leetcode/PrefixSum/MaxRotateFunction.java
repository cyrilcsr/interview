package com.algorithms.leetcode.PrefixSum;

/*
Leeetcode 0396
 */
public class MaxRotateFunction {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int rotateSum = 0;
        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
            rotateSum+=i*nums[i];
        }
        int result = rotateSum;
        for(int i=len-1;i>=0;i--){
            rotateSum-= (len-1)*nums[i];
            rotateSum+= (sum-nums[i]);
            result=Math.max(result,rotateSum);
        }

        return result;
    }
}
