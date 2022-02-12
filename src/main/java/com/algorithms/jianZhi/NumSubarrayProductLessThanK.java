package com.algorithms.jianZhi;

/*
JianZhi Offer 2-009
Leeetcode 0713
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums.length==0){
            return 0;
        }
        if (k <= 1) return 0;
        int result = 0;

        int low =0;
        int high =0;
        int product = nums[0];

        while(high<nums.length){
            if(product<k){
//                System.out.println(high-low+1);
//                System.out.println("low: "+ low +"  high: "+ high);
                result+=high-low+1;
                high++;
                if(high<nums.length){
                    product*=nums[high];
                }

            }else{
                product/=nums[low];
                low++;
            }
        }
        return result;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

}
