package com.algorithms.leetcode;
/*
Leeetcode 0798
 */
public class BestRotation {
    public int bestRotation(int[] nums) {
        int len = nums.length;
        int[] diff = new int[len];
        for(int i=0;i<len;i++){
//            if(nums[i]<=i){
//                //将区间[0,index-num]+1
//                diff[0]++;
//                diff[(i-nums[i]+1)%len]--;
//                //将区间[index+1,len-1]+1
//                diff[(i+1)%len]++;
//            }else{
//                //将区间[index+1，len-(num-index)+1
//                diff[(i+1)%len]++;
//                if(len+i-nums[i]+1<len){
//                    diff[len+i-nums[i]+1]--;
//                }
//            }

            int low = (i+1)%len;
            int high = (i-nums[i]+len+1)%len;
            if(low>high){
                diff[0]++;
            }
            diff[low]++;
            diff[high]--;
        }

        int result = 0;
        int max = diff[0];
        int score = 0;
        for(int i=0;i<len;i++){
            score +=diff[i];
            if(score>max){
                max = score;
                result = i;
            }
        }

        return result;
    }
}
