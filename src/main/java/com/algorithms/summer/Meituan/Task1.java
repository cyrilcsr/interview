package com.algorithms.summer.Meituan;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        char[] sArray = s.toCharArray();
        int countA = 0,countB = 0, countC=0;
        for(char c:sArray){
            if(c=='a') countA++;
            if(c=='b') countB++;
            if(c=='c') countC++;
        }

        int result = Math.min(Math.min(countB,countC/3),countA-1);

        System.out.println(result);
    }
}
