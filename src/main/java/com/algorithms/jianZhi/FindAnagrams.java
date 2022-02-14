package com.algorithms.jianZhi;

import java.util.ArrayList;
import java.util.List;

/*
JianZhi Offer 2-015
Leeetcode 0438
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> results = new ArrayList<>();

        int len1 = s.length();
        int len2 = p.length();

        if(len1<len2){
            return results;
        }

        int[] letterCount = new int[26];

        for(int i=0;i<len2;i++){
            letterCount[p.charAt(i)-'a']++;
            letterCount[s.charAt(i)-'a']--;
        }

        if(allZero(letterCount)){
            results.add(0);
        }

        for(int i = len2;i<len1;i++){
            letterCount[s.charAt(i)-'a']--;
            letterCount[s.charAt(i-len2)-'a']++;
            if(allZero(letterCount)){
                results.add(i-len2+1);
            }
        }

        return results;
    }

    private boolean allZero(int[] nums){
        for(int num:nums){
            if(num!=0){
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) cnt[c]++;
        int lo = 0, hi = 0;
        List<Integer> res = new ArrayList<>();
        while (hi < s.length()) {
            if (cnt[s.charAt(hi)] > 0) {
                cnt[s.charAt(hi++)]--;
                if (hi - lo == p.length()) res.add(lo);
            } else {
                cnt[s.charAt(lo++)]++;
            }
        }
        return res;
    }

}
