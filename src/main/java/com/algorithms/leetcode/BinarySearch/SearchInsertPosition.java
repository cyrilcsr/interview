package com.algorithms.leetcode.BinarySearch;

/*
Leeetcode 0035
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                left = mid;
                break;
            }
            if(nums[mid]<target) left = mid+1;
            if(nums[mid]>target) right = mid-1;
        }
        return nums[left]<target?left+1:left;
    }
}
