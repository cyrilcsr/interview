package com.algorithms.jianZhi;

import java.util.Arrays;

/*
JianZhi Offer 2-012
Leeetcode 0724
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        for(int num:nums){
            totalSum+=num;
        }

        int prefixSum = 0;
        for(int i=0;i<nums.length;i++){
            if(totalSum-prefixSum*2 == nums[i]){
                return i;
            }
            prefixSum+=nums[i];
        }

        return -1;
    }
}
