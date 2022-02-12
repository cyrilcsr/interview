package com.algorithms.jianZhi;

/*
JianZhi Offer 2-008
Leeetcode 0209
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int result=0,low=0,high = 0,sum = 0;

        while(high<nums.length||sum >= target){
            if(sum < target){
                sum +=nums[high];
                high++;
            }
            if(sum >= target){
//                System.out.println("low: "+ low +"  high: "+ high);
                result = result==0?high-low:Math.min(result, high-low);
                sum-=nums[low];
                low++;
            }
        }

        return result;
    }
}
