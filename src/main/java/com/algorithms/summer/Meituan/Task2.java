package com.algorithms.summer.Meituan;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] points = new int[num];
        for(int i=0;i<num;i++){
            points[i] = sc.nextInt();
        }
        int pos1 = points[0];
        int pos2 = points[num-1];
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<num;i++){
            int distDiff = Math.abs((points[i]-pos1)-(pos2-points[i]));
            minDiff = Math.min(minDiff,distDiff);
        }
        System.out.println(minDiff);
    }
}
