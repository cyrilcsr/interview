package com.algorithms.leetcode.BinarySearch;

/*
Leeetcode 0704
 */
public class BinarySearch {
    //递归
    public int search(int[] nums, int target) {
        return search(nums,target,0, nums.length-1);
    }

    public int search(int[] nums, int target, int start, int end){
        if(start>end) return -1;
        int middle = start+(end-start)/2;
        if(nums[middle]==target) return start+(end-start)/2;
        if(nums[middle]<target) return search(nums,target,middle+1,end);
        if(nums[middle]>target) return search(nums,target,start,middle-1);
        return -1;
    }

    //迭代
    public int search2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
