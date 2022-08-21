package com.algorithms.summer.Alibaba;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int result = 0;
        for(int i=0;i<num;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            result+=(i+1)/2;
        }
        System.out.println(result);
    }
}
