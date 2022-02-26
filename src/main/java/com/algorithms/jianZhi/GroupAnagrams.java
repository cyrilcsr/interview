package com.algorithms.jianZhi;

import java.util.*;

/*
JianZhi Offer 2-033
Leeetcode 0049
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hashmap = new HashMap<>();
        for (String str : strs) {
            int[] letterCount = new int[26];
            for (char c : str.toCharArray()) {
                letterCount[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : letterCount) {
                sb.append((char) (i + 'a'));
            }
            String key = sb.toString();
            if (!hashmap.containsKey(key)) {
                hashmap.put(key, new ArrayList<>());
            }
            hashmap.get(key).add(str);
        }
        return new ArrayList<>(hashmap.values());
    }
}
