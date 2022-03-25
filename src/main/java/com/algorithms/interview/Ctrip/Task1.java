package com.algorithms.interview.Ctrip;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long x = sc.nextLong();
            String s = String.valueOf(x);
            int len  = s.length();
            StringBuilder sb = new StringBuilder();
            long result = 0;
            search:for(int i=0;i<=len;i++){
                for(int j=0;j<10;j++){
                    sb = new StringBuilder();
                    sb.append(s.substring(0,i));
                    sb.append(String.valueOf(j));
                    sb.append(s.substring(i));
                    long num = Long.parseLong(sb.toString());
                    if(num%7==0&&num!=x){
                        result=num;
                        break search;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
