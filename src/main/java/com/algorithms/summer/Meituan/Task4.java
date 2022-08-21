package com.algorithms.summer.Meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
        int sum = 0;
        for(int i=0;i<num;i++){
            nums[i] = sc.nextInt();
        }

        for(int i=1;i<=num;i+=2){
            for(int j=0;j<num;j++){
                if(j>=i-1){
                    int[] rangeArr = new int[i];
                    for(int k=0;k<i;k++){
                        rangeArr[k] = nums[j-k];
                    }
                    Arrays.sort(rangeArr);
                    sum+=rangeArr[i/2];
                }
            }
        }

        System.out.println(sum);
    }
}
