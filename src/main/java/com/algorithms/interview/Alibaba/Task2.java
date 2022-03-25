package com.algorithms.interview.Alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            for(int i=0;i<num;i++){
                long[] nums = new long[5];
                for(int j=0;j<5;j++){
                    nums[j] = sc.nextLong();
                }
                Arrays.sort(nums);
                long result = 0;
                result+=nums[1];
                result+=Math.min(nums[0],nums[2]-nums[1]);
                System.out.println(result);
            }
        }
    }
}
