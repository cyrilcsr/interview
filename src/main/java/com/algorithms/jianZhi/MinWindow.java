package com.algorithms.jianZhi;

import java.util.Arrays;

/*
JianZhi Offer 2-017
Leeetcode 0076
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        String result = "";

        if (s.length() < t.length()) {
            return "";
        }
        int[] counts = new int[128];


        for (char c : t.toCharArray()) {
            counts[c]++;
        }

        int[] tempCount = counts.clone();

        int low = 0;
        int high = 0;

        while (high < s.length()) {
            if (counts[s.charAt(high)] != 0) {
                tempCount[s.charAt(high)]--;
                if (allContains(tempCount)) {
                    while (true) {
                        if (counts[s.charAt(low)] != 0) {
                            tempCount[s.charAt(low)]++;
                            if (tempCount[s.charAt(low)] > 0) {
                                if (s.substring(low, high + 1).length() < result.length() || result.length() == 0) {
                                    result = s.substring(low, high + 1);
                                }
                                low++;
                                break;
                            }
                        }
                        low++;
                    }
                }
            }
            high++;

        }

        return result;
    }

    private boolean allContains(int[] nums) {
        for (int num : nums) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }

    public String minWindow2(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;

        int[] hash = new int[128];
        for (char ch : chart) hash[ch]--;

        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0) cnt++;
            while (cnt == m && hash[chars[j]] > 0) {
                hash[chars[j++]]--;
            }
            if (cnt == m)
                if (res.equals("") || res.length() > i - j + 1)
                    res = s.substring(j, i + 1);
        }
        return res;
    }

    public String minWindow3(String s, String t) {
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();

        int sLen = s.length();
        int tLen = t.length();

        String result = "";

        int[] letterCount = new int[128];

        for (char c : arrayT) {
            letterCount[c]++;
        }

        for (int i = 0, j = 0, cnt = 0; i < sLen; i++) {
            letterCount[arrayS[i]]--;

            if (letterCount[arrayS[i]] >= 0) {
                cnt++;
            }

            while (cnt == tLen && letterCount[arrayS[j]] < 0) {
                letterCount[arrayS[j++]]++;
            }

            if (cnt == tLen && (result.length() == 0 || result.length() > (i - j))) {
                result = s.substring(j, i + 1);
            }
        }

        return result;
    }
}
