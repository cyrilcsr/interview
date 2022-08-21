package com.algorithms.summer.NetEase;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        char[] sArray = s.toCharArray();
        int len = s.length();
        int[] marked = new int[len];

        int result = 0;
        if(len==1){
            System.out.println(result);
            return;
        }

        for(int i=0;i<len-1;i++){
            int x = sArray[i]-'a';
            int y = sArray[i+1]-'a';
            if(x-1<=y&&y<=x+1){
                if(marked[i]==0){
                    marked[i]+=x+1;
                }
                marked[i+1]+=y+1;
            }
        }
        int continues = 0;
        for(int i=0;i<=len;i++){
            if(i==len||marked[i]==0){
                if(continues!=0){
                    int sum = 0;
                    for(int j=1;j<=continues;j++){
                        sum+=marked[i-j];
                    }
                    if((continues&1)!=0){
                        int min = Integer.MAX_VALUE;
                        for(int j=1;j<=continues;j+=2){
                            min = Math.min(min,marked[i-j]);
                        }
                        sum-=min;
                    }
                    result+=sum;
                    continues=0;
                }
            }else{
                continues++;
            }
        }
        System.out.println(result);
    }
}
