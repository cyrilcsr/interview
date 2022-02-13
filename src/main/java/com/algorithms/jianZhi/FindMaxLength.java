package com.algorithms.jianZhi;

import java.util.HashMap;
import java.util.jar.JarEntry;

/*
JianZhi Offer 2-011
Leeetcode 0525
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i]==0 ? -1 : 1;
            if(map.containsKey(sum)){
                result = Math.max(result,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }

        return result;
    }
}
