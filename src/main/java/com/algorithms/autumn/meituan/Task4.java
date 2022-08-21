package com.algorithms.autumn.meituan;

import java.util.Arrays;
import java.util.Scanner;

class Pair{
    int key;
    int val;
    Pair(int key, int val){
        this.key = key;
        this.val = val;
    }
}
public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            Pair[] nums = new Pair[n];
            for(int i=0;i<n;i++){
                nums[i] = new Pair(sc.nextInt(),i);
            }
            Arrays.sort(nums,(a,b)->a.key-b.key);
            int result = 0;

//            for(int i=0;i<n;i++){
//                int cnt = 0;
//                int j=i+1,k=n-1;
//                while(j<k){
//                    if(j==i){
//                        j++; continue;
//                    }
//                    if(k==i){
//                        k--; continue;
//                    }
//                    int jCount = 1;
//                    int kCount = 1;
//                    while(j+1<k&&nums[j]==nums[j+1]){
//                        j++;
//                        jCount++;
//                    }
//                    while(k-1>j&&nums[k]==nums[k-1]){
//                        k--;
//                        kCount++;
//                    }
//                    if(nums[j]+nums[k]==3*nums[i]){
//                        result+=jCount*kCount;
//                        j++;
//                        k--;
//                    }else if(nums[j]+nums[k]<3*nums[i]){
//                        j++;
//                    }else{
//                        k--;
//                    }
//                }
//            }
            System.out.println(result);
        }
    }
}
