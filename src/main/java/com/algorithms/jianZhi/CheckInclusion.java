package com.algorithms.jianZhi;


/*
JianZhi Offer 2-014
Leeetcode 0567
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len>s2Len){
            return false;
        }

        int[] letterCount = new int[26];
        for(int i=0;i<s1Len;i++){
            letterCount[s1.charAt(i)-'a']++;
            letterCount[s2.charAt(i)-'a']--;
        }

        if(allZero(letterCount)){
            return true;
        }

        for(int i=s1Len;i<s2Len;i++){
            letterCount[s2.charAt(i)-'a']--;
            letterCount[s2.charAt(i-s1Len)-'a']++;
            if(allZero(letterCount)) {
                return true;
            }
        }
        return false;

    }

    private boolean allZero(int[] nums){
        for(int num:nums){
            if(num!=0){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                ++diff;
            }
            ++cnt[x];
            if (cnt[x] == 0) {
                --diff;
            }
            if (cnt[y] == 0) {
                ++diff;
            }
            --cnt[y];
            if (cnt[y] == 0) {
                --diff;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

}
