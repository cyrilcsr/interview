package com.algorithms.autumn.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nodes = new int[n];
            for(int i=0;i<n;i++){
                nodes[i] = sc.nextInt();
            }
            int[] dp = new int[n+1];
            int result = 0;
            dp[1] = nodes[0];
            int max = dp[1];

            for(int i=1;i<n;i++){
                int curr = i+1;
                int parent = curr>>1;
                dp[curr] = dp[parent]+nodes[i];
                max = Math.max(max,dp[curr]);
            }


            System.out.println(max);
        }
    }
}
