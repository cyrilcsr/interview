package com.algorithms.jianZhi;

/*
JianZhi Offer 2-016
Leeetcode 0003
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }

        int[] letterCount = new int[128];

        int result =0;

        int low = 0;
        int high = 0;

        for(;high<s.length();high++){
            letterCount[s.charAt(high)]++;
            if(letterCount[s.charAt(high)]>1){
                while(low<high){
                    if(s.charAt(low)==s.charAt(high)){
                        letterCount[s.charAt(low)]--;
                        low++;
                        break;
                    }
                    letterCount[s.charAt(low)]--;
                    low++;

                }
            }
            result = Math.max(result,high-low+1);
        }

        return result;
    }


}
