package com.algorithms.leetcode;

/*
Leeetcode 2044
*/
public class CountMaxOrSubsets {
    int maxOr;
    int result;
    int[] nums;
    public int countMaxOrSubsets(int[] nums) {
        maxOr = 0;
        result = 0;
        this.nums = nums;
        helper(0,0);

        return result;
    }

    private void helper(int index, int or){
        if(index==nums.length){
            if(or>maxOr){
                result=1;
                maxOr = or;
            }else if(or==maxOr){
                result++;
            }
            return;
        }
        helper(index+1,or|nums[index]);
        helper(index+1,or);
    }

    int sum = 0;
    public int countMaxOrSubsets2(int[] nums) {
        int max = 0;
        for(int p : nums){
            max |= p;
        }
        backtracking(nums,0,0,max);
        return sum;
    }
    public void backtracking(int[] nums,int start,int all,int max){
        if(all == max){
            sum += 1 << (nums.length - start);
            return;
        }
        for (int i = start;i < nums.length;i++){
            backtracking(nums,i + 1,all | nums[i],max);
        }
    }
}
