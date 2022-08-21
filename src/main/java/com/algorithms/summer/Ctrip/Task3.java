package com.algorithms.summer.Ctrip;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();

            int[] hash = new int[26];
            char[] sArray = s.toCharArray();
            int left = 0, right = 0;
            int count = 0;
            int result = 0;
            while(right<n){
                if(count<=k){
                    if(hash[sArray[right]-'a']==0){
                        count++;
                    }
                    hash[sArray[right]-'a']++;
                    right++;
                }else{
                    if(hash[sArray[left]-'a']==1){
                        count--;
                    }
                    hash[sArray[left]-'a']--;
                    left++;
                }
                if(count<=k) {
                    result = Math.max(result,right-left);
                }
                System.out.println("left:"+left+"  right:"+right+"   count:"+count+"   result:"+result);
            }
            System.out.println(result);
        }
    }
}
