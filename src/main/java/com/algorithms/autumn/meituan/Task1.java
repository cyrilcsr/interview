package com.algorithms.autumn.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int t = sc.nextInt();
            int[] orders = new int[n];
            for(int i=0;i<n;i++){
                orders[i] = sc.nextInt();
            }
            Arrays.sort(orders);

            int result = 0;
            int curr = 0;
            for(int i=0;i<n;i++){
                if(curr+t<=orders[i]){
                    curr+=t;
                }else{
                    result++;
                }
            }

            System.out.println(result);
        }
    }
}
