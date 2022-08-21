package com.algorithms.summer.Microsoft.Intern;

public class Task1 {
    public String solution(String S, String T) {
        // write your code in Java SE 8
        int lenS = S.length();
        int lenT = T.length();
        if(lenS>lenT||lenS<lenT-1){
            return "IMPOSSIBLE";
        }
        if(S.equals(T)){
            return "NOTHING";
        }

        int[] cnt1 = new int[26], cnt2 = new int[26];
        int sum = 0;
        char firstDiffT=' ';
        char firstDiffS=' ';
        int insertFlag=0;
        for (int i = 0; i < lenT; i++) {
            int a,b;
            if(lenS<lenT&&insertFlag==1){
                a = S.charAt(i-1) - 'a';
            }else{
                a = S.charAt(i) - 'a';
            }
            b = T.charAt(i) - 'a';
            cnt1[a]++; cnt2[b]++;
            if (a != b) {
                if(sum==0){
                    insertFlag=1;
                    firstDiffS = S.charAt(i);
                    firstDiffT = T.charAt(i);
                }
                sum++;
            }
        }

        if(sum==1){
            if(lenS==lenT){
                return "CHANGE "+firstDiffS+" "+firstDiffT;
            }
            if(lenS<lenT){
                return "INSERT "+firstDiffT;
            }
        }
        if(sum==2){
            for (int i = 0; i < 26; i++) {
                if (cnt1[i] != cnt2[i]) return "IMPOSSIBLE";
            }
            return "SWAP "+firstDiffS+" "+firstDiffT;
        }

        return "IMPOSSIBLE";
    }
}
