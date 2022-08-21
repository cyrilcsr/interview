package com.algorithms.summer.Ctrip;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            char[] sArray = s.toCharArray();
            int result = Math.min(getCount(sArray,'0'),getCount(sArray,'1'));

            System.out.println(result);
        }
    }
    private static int getCount(char[] sArray,char prev){
        int len = sArray.length;
        int cost = 0;
        for(int i=0;i<len;i++){
            if(sArray[i]==prev){
                if(prev=='0'){
                    prev='1';
                }else{
                    prev='0';
                }
                cost+=(i+1);
            }else{
                prev = sArray[i];
            }
        }
        return cost;
    }
}
