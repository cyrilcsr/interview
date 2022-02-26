package com.algorithms.jianZhi;
/*
JianZhi Offer 2-032
Leeetcode 0242
 */
public class isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] hashMap = new int[26];

        for(char c:s.toCharArray()){
            hashMap[c-'a']++;
        }
        for(char c:t.toCharArray()){
            hashMap[c-'a']--;
        }
        for(int i:hashMap){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()|| s.equals(t)) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
