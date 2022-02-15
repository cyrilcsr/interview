package com.algorithms.jianZhi;

/*
JianZhi Offer 2-019
Leeetcode 0680
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        return validPalindrome(s,false);
    }

    private boolean validPalindrome(String s, boolean deleted) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                if(deleted==false){
                    return validPalindrome(s.substring(low,high), true)
                            ||validPalindrome(s.substring(low+1,high+1), true);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
