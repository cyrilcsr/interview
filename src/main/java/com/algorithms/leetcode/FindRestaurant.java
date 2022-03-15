package com.algorithms.leetcode;

/*
Leeetcode 599
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i< list1.length;i++){
            hashMap.put(list1[i],i);
        }
        for(int i=0;i< list2.length;i++){
            if(hashMap.containsKey(list2[i])){
                int index = hashMap.get(list2[i])+i;
                if(index==minIndex){
                    result.add(list2[i]);
                }
                if(index<minIndex){
                    result = new ArrayList<>();
                    minIndex = index;
                    result.add(list2[i]);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
