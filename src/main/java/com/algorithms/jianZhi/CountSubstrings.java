package com.algorithms.jianZhi;

import java.util.Locale;

/*
JianZhi Offer 2-020
Leeetcode 0647
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            count+=countPalindromic(s,i,i);
            count+=countPalindromic(s,i,i+1);
        }
        return count;
    }

    private int countPalindromic(String s, int start, int end){
        int count=0;
        while(start>=0&&end<s.length()){
            if(s.charAt(start)==s.charAt(end)){
                count++;
                start--;
                end++;
            }else{
                break;
            }
        }
        return count;
    }

    public int countSubstrings2(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }

}
